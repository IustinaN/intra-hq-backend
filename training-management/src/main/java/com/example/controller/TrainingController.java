package com.example.controller;

import com.example.events.CustomEvent;
import com.example.events.Event;
import com.example.postgreSql.model.Training;
import com.example.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class TrainingController {


    //TODO: DTO?
    @Autowired
    private TrainingService trainingService;

    @GetMapping("/training")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<Training>> getTrainings() {
        List<Training> trainings = trainingService.getAllTrainings();
        return ResponseEntity.status(HttpStatus.OK).body(trainings);
    }

    @GetMapping("/training/{id}")
    ResponseEntity<Training> getTrainingById(@PathVariable String id) {
        Training training= trainingService.getTrainingById(Long.valueOf(id));
        return ResponseEntity.status(HttpStatus.OK).body(training);
    }

    @PostMapping("/training")
    ResponseEntity<CustomEvent> addTraining(@RequestBody Training training){
        CustomEvent trainingCreatedEvent =  trainingService.addNewTraining(training);
        return ResponseEntity.status(HttpStatus.OK).body(trainingCreatedEvent);
    }

    @PutMapping("/training/{id}")
    ResponseEntity<CustomEvent> updateTraining(@PathVariable String id, @RequestBody Training training) {
        CustomEvent trainingUpdatedEvent =   trainingService.updateTraining(id, training);
        return ResponseEntity.status(HttpStatus.OK).body(trainingUpdatedEvent);
    }

    @DeleteMapping("/training/{id}")
    ResponseEntity<CustomEvent> removeTraining(@PathVariable String id){
        CustomEvent trainingDeletedEvent = trainingService.removeTraining(id);
        return ResponseEntity.status(HttpStatus.OK).body(trainingDeletedEvent);
    }
}
