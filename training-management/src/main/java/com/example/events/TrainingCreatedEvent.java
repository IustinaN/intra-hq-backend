package com.example.events;

import com.example.postgreSql.model.Training;

import java.util.Date;

public class TrainingCreatedEvent implements CustomEvent{
    private Date createdDate;
    private Training training;

    public TrainingCreatedEvent() {
    }

    public TrainingCreatedEvent(Training training) {
        this.createdDate= new Date();
        this.training = training;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
