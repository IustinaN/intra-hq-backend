package com.example.service;

import com.example.events.*;
import com.example.kafka.EventProducer;
import com.example.postgreSql.model.Training;
import com.example.postgreSql.repository.TrainingRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private ModelMapper modelMapper;

    public List<Training> getAllTrainings() {
        return (List<Training>) trainingRepository.findAll();
    }

    public Training getTrainingById(Long id) {
        return trainingRepository.findById(id).get();
    }

    @Transactional
    public CustomEvent addNewTraining(Training newTraining) {
        trainingRepository.save(newTraining);

//        Event newEvent = new Event(EventType.INSERT, new Date(), new Gson().toJson(newTraining));
        TrainingCreatedEvent newEvent = new TrainingCreatedEvent(newTraining);
        eventProducer.sendEvent(newEvent);

        return newEvent;
    }

    @Transactional
    public CustomEvent updateTraining(String id, Training training) {
        CustomEvent updateEvent = null;

        if (trainingRepository.findById(Long.valueOf(id)).isPresent()) {
            Training updatedTraining = modelMapper.map(training, Training.class);
            updatedTraining.setTrainingId(Long.valueOf(id));

            trainingRepository.save(updatedTraining);
            updateEvent = new TrainingUpdatedEvent(updatedTraining);
        } else {
            updateEvent = new TrainingErrorEvent(id, "Error: training is not in database");
        }

        eventProducer.sendEvent(updateEvent);

        return updateEvent;
    }

    @Transactional
    public CustomEvent removeTraining(String id) {
        CustomEvent trainingDeletedEvent = null;
        Optional<Training> training = trainingRepository.findById(Long.valueOf(id));

        if (training.isPresent()) {
            trainingRepository.delete(training.get());
            trainingDeletedEvent = new TrainingDeletedEvent(training.get());
            eventProducer.sendEvent(trainingDeletedEvent);
        } else {
            trainingDeletedEvent = new TrainingErrorEvent(id, "Error: training is not in database");
        }

        return trainingDeletedEvent;
    }
}