package com.bezkoder.spring.jwt.mongodb.controllers;


import com.bezkoder.spring.jwt.mongodb.models.Evidence;
import com.bezkoder.spring.jwt.mongodb.network.response.BaseResponse;
import com.bezkoder.spring.jwt.mongodb.repository.AssociatedPersonRepository;
import com.bezkoder.spring.jwt.mongodb.repository.CaseInformationRepository;
import com.bezkoder.spring.jwt.mongodb.repository.EvidenceRepository;
import com.bezkoder.spring.jwt.mongodb.repository.ItemInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<?> getAllDraftTenders() {
        ResponseEntity<?> result = null;

        List<Evidence> allEvidences = evidenceRepository.findAll();
        result = new ResponseEntity<>(allEvidences, HttpStatus.CREATED);

        return result;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTender(@Valid @RequestBody Evidence evidence) {
        ResponseEntity<?> result = null;

        try {
            associatedPersonRepository.save(evidence.getAssociatedPerson());
            itemInformationRepository.save(evidence.getItemInformation());
            caseInformationRepository.save(evidence.getCaseInformation());

            Evidence _evidence = evidenceRepository.save(evidence);
            result = new ResponseEntity<>(_evidence, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            result = ResponseEntity
                    .badRequest()
                    .body(new BaseResponse("Bad Response.",false));
        }

        return result;
    }
}
