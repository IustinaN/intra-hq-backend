package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//        trainingService.addNewTraining();

//        trainingService.addTrainingItem();
//        System.out.println("------------ ADD A TRAINING CATALOGUE -----------------");
//        trainingService.addTrainingCatalogue(TrainingUtil.createTrainingCatalogue());
//
//        System.out.println("---------------- ADD TRAINING ITEM AND ADD IT TO TRAINING CATALOGUE ---------");
//        TrainingItem newTrainingItem = TrainingUtil.createTrainingItem();
//        trainingService.addTrainingItemAndUpdateCatalogue(newTrainingItem);
//
//        System.out.println("----------------- ADD TRAINING REQUEST ---------------------");
//        trainingService.addTrainingRequest(TrainingUtil.createTrainingRequest(newTrainingItem));
//
//        System.out.println("---------- GET TRAINING DETAILS ----------");
//        System.out.println(trainingService.find("Training1").toString());
//
//        System.out.println("---------------------- GENERATE AND ADD NEW TRAINING ITEM EVENT ----------------");
//        Gson gson = new Gson();
//        String payload = gson.toJson(newTrainingItem);
//        System.out.println("PAYLOAD: " + payload);
////
//        CustomEvent newEvent = generateEventWithPayload(EventType.INSERT, payload);
//        System.out.println("AAAAAAAAAAA: " + gson.toJson(newEvent));
//        eventService.addEvent(newEvent);
//
//        Training itm = gson.fromJson(payload, Training.class);
////        psTrainingService.addNewTraining(itm);
//
//        String payload1 = "{\"trainingItemId\":\"59f62d89f8272a70f5c8ef14\",\"name\":\"Training1000000\"}";
//        CustomEvent updateEvent = generateEventWithPayload(EventType.UPDATE, payload1);
//        eventService.addEvent(updateEvent);
//
//        Training itmToUp = gson.fromJson(payload1, Training.class);
//        System.out.println("ITM TO UP: "+ itmToUp);
//        psTrainingService.addNewTraining(itmToUp);

}

