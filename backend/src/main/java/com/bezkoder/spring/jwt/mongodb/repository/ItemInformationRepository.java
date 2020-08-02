package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.CaseInformation;
import com.bezkoder.spring.jwt.mongodb.models.ItemInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemInformationRepository extends MongoRepository<ItemInformation,String> {

}
