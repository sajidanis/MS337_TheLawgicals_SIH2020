package com.bezkoder.spring.jwt.mongodb.controllers;


import com.bezkoder.spring.jwt.mongodb.cloudVision.CloudVisionService;
import com.bezkoder.spring.jwt.mongodb.models.CaseInformation;
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

import java.nio.file.Path;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/case")
public class CaseController {

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
    public ResponseEntity<?> getAll() {
        ResponseEntity<?> result = null;

        List<CaseInformation> allCaseInfo = caseInformationRepository.findAll();
        result = new ResponseEntity<>(allCaseInfo, HttpStatus.CREATED);

        return result;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,consumes = MULTIPART_FORM_DATA_VALUE)
    public @ResponseBody ResponseEntity<?> upload( @RequestParam(value = "document",required = false) MultipartFile document,
                                                   @RequestParam("case") String caseString) throws Exception {
        ResponseEntity<?> result = null;

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        CaseInformation caseInformation = objectMapper.readValue(caseString, CaseInformation.class);

        if (document != null){
            Path evidencePath = Path.of(document.getOriginalFilename());
            minioService.upload(evidencePath, document.getInputStream(), document.getContentType());
            caseInformation.setCaseDocumentPath(String.valueOf(evidencePath));

            String documentText = null;
            BatchAnnotateImagesResponse response = cloudVisionService.detectTextInputString(document.getInputStream());
            if (response.getResponsesList().size() > 0){
                documentText = response.getResponsesList().get(0).getFullTextAnnotation().getText();
            }else {
                documentText = "Unable to process";
            }

            caseInformation.setDocumentConvertedText(documentText);
        }

        try {
            CaseInformation _caseInformation = caseInformationRepository.save(caseInformation);
            transactionService.log("","case_created","",_caseInformation);
            result = new ResponseEntity<>(_caseInformation, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            result = ResponseEntity
                    .badRequest()
                    .body(new BaseResponse("Bad Response.",false));
        }

        return result;
    }
}
