package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.CaseInformation;
import com.bezkoder.spring.jwt.mongodb.models.Evidence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CaseInformationRepository extends MongoRepository<CaseInformation,String> {

}
