package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.AssociatedPerson;
import com.bezkoder.spring.jwt.mongodb.models.Evidence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssociatedPersonRepository extends MongoRepository<AssociatedPerson,String> {

}
