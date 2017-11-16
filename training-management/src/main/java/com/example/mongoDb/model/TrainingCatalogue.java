package com.example.mongoDb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "trainingCatalogue")
public class TrainingCatalogue {

    @Id
    private String id;
    private List<TrainingItem> trainingItems;
    private String owner;
    private String lastUpdated;

    public TrainingCatalogue() {
    }

    public List<TrainingItem> getTrainingItems() {
        return trainingItems;
    }

    public void setTrainingItems(List<TrainingItem> trainingItems) {
        this.trainingItems = trainingItems;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
