package com.example.mongoDb.repository;

import com.example.mongoDb.model.TrainingRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TrainingRequestRepository extends CrudRepository<TrainingRequest, String>, MongoRepository<TrainingRequest, String> {

    @Query(value = "{'employee.name' : ?0}", count = true)
    int getTrainingRequestsNumberPerEmployee(String employeeName);
}
