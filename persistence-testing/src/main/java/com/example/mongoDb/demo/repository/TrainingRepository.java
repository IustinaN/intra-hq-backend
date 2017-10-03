package com.example.mongoDb.demo.repository;

import com.example.mongoDb.demo.model.Training;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainingRepository extends MongoRepository<Training, String> {

    Training findByName(String name);
}
