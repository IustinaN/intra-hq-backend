package com.example.util;

import com.example.mongoDb.model.*;

import java.util.Date;

public final class TrainingUtil {

    public static TrainingItem createTrainingItem() {
        TrainingItem newTrainingItem = new TrainingItem();
        newTrainingItem.setTrainingItemId("trainingId1");
        newTrainingItem.setName("Training11111111");
        newTrainingItem.setDescription("Some Description19");
        newTrainingItem.setTrainingType(TrainingType.EXTERNAL);
        newTrainingItem.setMandatory(Mandatory.TRUE);
        newTrainingItem.setProvider("Edurom");
        newTrainingItem.setStartDate("17/02/2018");
        newTrainingItem.setEndDate("17/02/2018");
        newTrainingItem.setNoOfPoints(120);

        return newTrainingItem;
    }

    public static TrainingCatalogue createTrainingCatalogue() {
        TrainingCatalogue trainingCatalogue = new TrainingCatalogue();
        trainingCatalogue.setTrainingItems(null);
        trainingCatalogue.setLastUpdated(new Date().toString());
        trainingCatalogue.setOwner("meee");
        return trainingCatalogue;
    }

    public static TrainingRequest createTrainingRequest(TrainingItem trainingItem){
        Employee employee = new Employee("Iustina");
        return new TrainingRequest(employee, trainingItem);
    }
}
