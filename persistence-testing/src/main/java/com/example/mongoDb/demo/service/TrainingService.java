package com.example.mongoDb.demo.service;

import com.example.mongoDb.demo.model.Training;
import com.example.mongoDb.demo.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    public Training addNewTraining(Training training) {
        return trainingRepository.insert(training);
    }
}
