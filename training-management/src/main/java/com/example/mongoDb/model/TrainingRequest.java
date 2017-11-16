package com.example.mongoDb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trainingRequests")
public class TrainingRequest {

    @Id
    private String id;
    private Employee employee;
    private TrainingItem trainingItem;

    public TrainingRequest(Employee employee, TrainingItem trainingItem) {
        this.employee = employee;
        this.trainingItem = trainingItem;
    }

    public Employee getEmployee() {
        return employee;
    }
}
