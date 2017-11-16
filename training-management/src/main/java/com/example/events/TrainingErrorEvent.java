package com.example.events;

import com.example.postgreSql.model.Training;

import java.util.Date;

public class TrainingErrorEvent implements CustomEvent{
    private Date errorDate;
    private String id;
    private String message;

    public TrainingErrorEvent(String id, String message) {
        this.errorDate = new Date();
        this.id = id;
        this.message=message;
    }

    public Date getErrorDate() {
        return errorDate;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
