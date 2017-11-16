package com.example.mongoDb.repository;

import com.example.mongoDb.model.TrainingItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface TrainingItemRepository extends CrudRepository<TrainingItem, String>, MongoRepository<TrainingItem, String> {

    TrainingItem findByName(String name);
}
