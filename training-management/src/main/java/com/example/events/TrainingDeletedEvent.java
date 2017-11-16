package com.example.events;

import com.example.postgreSql.model.Training;

import java.util.Date;

public class TrainingDeletedEvent implements CustomEvent {

    private Date deletedDate;
    private Training training;

    public TrainingDeletedEvent() {
    }

    public TrainingDeletedEvent(Training training) {
        this.deletedDate = new Date();
        this.training = training;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
