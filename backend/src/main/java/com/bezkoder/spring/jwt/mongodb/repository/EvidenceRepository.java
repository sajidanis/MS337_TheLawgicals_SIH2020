package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.Evidence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvidenceRepository extends MongoRepository<Evidence,String> {
}
