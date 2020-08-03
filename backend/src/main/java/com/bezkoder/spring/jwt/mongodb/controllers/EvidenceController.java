package com.bezkoder.spring.jwt.mongodb.controllers;


import com.bezkoder.spring.jwt.mongodb.cloudVision.CloudVisionService;
import com.bezkoder.spring.jwt.mongodb.models.Evidence;
import com.bezkoder.spring.jwt.mongodb.network.response.BaseResponse;
import com.bezkoder.spring.jwt.mongodb.repository.AssociatedPersonRepository;
import com.bezkoder.spring.jwt.mongodb.repository.CaseInformationRepository;
import com.bezkoder.spring.jwt.mongodb.repository.EvidenceRepository;
import com.bezkoder.spring.jwt.mongodb.repository.ItemInformationRepository;
import com.bezkoder.spring.jwt.mongodb.services.TransactionService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.jlefebure.spring.boot.minio.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Path;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/evidence")
public class EvidenceController {

    @Autowired
    private EvidenceRepository evidenceRepository;

    @Autowired
    private CaseInformationRepository caseInformationRepository;

    @Autowired
    private AssociatedPersonRepository associatedPersonRepository;

    @Autowired
    private ItemInformationRepository itemInformationRepository;

    @Autowired
    MinioService minioService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    CloudVisionService cloudVisionService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllDraftTenders() {
        ResponseEntity<?> result = null;

        List<Evidence> allEvidences = evidenceRepository.findAll();
        result = new ResponseEntity<>(allEvidences, HttpStatus.CREATED);

        return result;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,consumes = MULTIPART_FORM_DATA_VALUE)
    public @ResponseBody ResponseEntity<?> upload( @RequestParam(value = "document",required = false) MultipartFile document,
                                                   @RequestParam("evidence") String evidenceString) throws Exception {
        ResponseEntity<?> result = null;

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Evidence evidence1 = objectMapper.readValue(evidenceString, Evidence.class);

        if (document != null){
            Path evidencePath = Path.of(document.getOriginalFilename());
            minioService.upload(evidencePath, document.getInputStream(), document.getContentType());
            evidence1.setDocumentPath(String.valueOf(evidencePath));

            String documentText = null;
            BatchAnnotateImagesResponse response = cloudVisionService.detectTextInputString(document.getInputStream());
            if (response.getResponsesList().size() > 0){
                documentText = response.getResponsesList().get(0).getFullTextAnnotation().getText();
            }else {
                documentText = "Unable to process";
            }

            evidence1.setDocumentConvertedText(documentText);
        }

        try {
            associatedPersonRepository.save(evidence1.getAssociatedPerson());
            itemInformationRepository.save(evidence1.getItemInformation());
            caseInformationRepository.save(evidence1.getCaseInformation());

            Evidence _evidence = evidenceRepository.save(evidence1);
            transactionService.log("","evidence_created","",_evidence);
            result = new ResponseEntity<>(_evidence, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            result = ResponseEntity
                    .badRequest()
                    .body(new BaseResponse("Bad Response.",false));
        }

        return result;
    }

//    @PostMapping("/create")
//    public ResponseEntity<?> createTender(@Valid @RequestBody Evidence evidence) {
//        ResponseEntity<?> result = null;
//
//
//        try {
//            associatedPersonRepository.save(evidence.getAssociatedPerson());
//            itemInformationRepository.save(evidence.getItemInformation());
//            caseInformationRepository.save(evidence.getCaseInformation());
//
//            Evidence _evidence = evidenceRepository.save(evidence);
//            result = new ResponseEntity<>(_evidence, HttpStatus.CREATED);
//        }catch (Exception e){
//            e.printStackTrace();
//            result = ResponseEntity
//                    .badRequest()
//                    .body(new BaseResponse("Bad Response.",false));
//        }
//
//        return result;
//    }
}
