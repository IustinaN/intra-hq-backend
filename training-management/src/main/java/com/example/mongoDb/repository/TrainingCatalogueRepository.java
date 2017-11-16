package com.example.mongoDb.repository;

import com.example.mongoDb.model.TrainingCatalogue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface TrainingCatalogueRepository extends CrudRepository<TrainingCatalogue, String>, MongoRepository<TrainingCatalogue, String> {

    TrainingCatalogue findByOwner(String ownerName);
}
