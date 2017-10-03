package com.example.mongoDb.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

@Document(collection = "trainings")
public class Training {

    @Id
    private String id;
    private String name;
    private String description;
    private String mandatory;
    private String date;
    private String status;
    private int noOfPoints;

    public Training() {
    }

    public Training(String name, String description, String mandatory, String date, String status, int noOfPoints) {
        this.setName(name);
        this.setDescription(description);
        this.setMandatory(mandatory);
        this.setDate(date);
        this.setStatus(status);
        this.setNoOfPoints(noOfPoints);
    }

    public void setName(String name) {
        if (StringUtils.isEmpty(name) || name == null) {
            throw new IllegalArgumentException("Name attribute should not be empty.");
        }

        this.name = name;
    }

    public void setDescription(String description) {
        if (StringUtils.isEmpty(description) || description == null) {
            throw new IllegalArgumentException("Description attribute should not be empty.");
        }

        this.description = description;
    }

    public void setMandatory(String mandatory) {
        if (StringUtils.isEmpty(mandatory) || mandatory == null) {
            throw new IllegalArgumentException("Mandatory attribute should not be empty.");
        }

        this.mandatory = mandatory;
    }

    public void setDate(String date) {
        if (StringUtils.isEmpty(date) || date == null) {
            throw new IllegalArgumentException("Date attribute should not be empty.");
        }

        this.date = date;
    }

    public void setStatus(String status) {
        if (StringUtils.isEmpty(status) || status == null) {
            throw new IllegalArgumentException("Status attribute should not be empty.");
        }

        this.status = status;
    }

    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    @Override
    public String toString() {
        return String.format("Training[id=%s, name='%s', description='%s', mandatory='%s', date='%s'," +
            "status='%s', noOfPoints='%s']", id, name, description, mandatory, date, status, noOfPoints);
    }
}
