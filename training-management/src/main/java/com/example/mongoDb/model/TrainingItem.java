package com.example.mongoDb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "trainingItems")
public class TrainingItem {

    @Id
    @Field(value = "training_item_id")
    private String trainingItemId;

    @Indexed(unique = true)
    private String name;
    private String description;
    private TrainingType type;
    private Mandatory mandatory;
    private int noOfPoints;
    private String provider;
    private String startDate;
    private String endDate;

    public TrainingItem() {
    }

    public String getTrainingItemId() {
        return trainingItemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TrainingType getType() {
        return type;
    }

    public Mandatory getMandatory() {
        return mandatory;
    }

    public int getNoOfPoints() {
        return noOfPoints;
    }

    public String getProvider() {
        return provider;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setTrainingItemId(String trainingItemId) {
        this.trainingItemId = trainingItemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTrainingType(TrainingType type) {
        this.type = type;
    }

    public void setMandatory(Mandatory mandatory) {
        this.mandatory = mandatory;
    }

    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return String.format("TrainingItem[trainingItemId=%s, name='%s', description='%s', type='%s', mandatory='%s', " +
                        "noOfPoints='%s', provider='%s', startDate='%s', endDate='%s']",
                trainingItemId, name, description, type, mandatory,
                noOfPoints, provider, startDate, endDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (trainingItemId == null || obj == null || getClass() != obj.getClass())
            return false;
        TrainingItem that = (TrainingItem) obj;
        return trainingItemId.equals(that.trainingItemId);
    }

    @Override
    public int hashCode() {
        return trainingItemId == null ? 0 : trainingItemId.hashCode();
    }
}
