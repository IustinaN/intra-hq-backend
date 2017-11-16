package com.example.events;

import com.example.postgreSql.model.Training;

import java.util.Date;

public class TrainingUpdatedEvent implements CustomEvent{
    private Date updatedDate;
    private Training training;

    public TrainingUpdatedEvent() {
    }

    public TrainingUpdatedEvent(Training training) {
        this.updatedDate = new Date();
        this.training = training;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
