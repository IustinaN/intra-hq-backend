package com.example.kafka;

import com.example.events.TrainingCreatedEvent;
import com.example.events.TrainingDeletedEvent;
import com.example.events.TrainingUpdatedEvent;
import com.example.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {

    @Autowired
    private EventService eventService;

    @KafkaListener(topics = "trainingEventTopic")
    public void processTrainingCreatedEvent(TrainingCreatedEvent event) {
        System.out.println("Received payload: " + event);
        eventService.addEvent(event);
    }

    @KafkaListener(topics = "trainingEventTopic")
    public void processTrainingUpdatedEvent(TrainingUpdatedEvent event) {
        eventService.addEvent(event);
    }

    @KafkaListener(topics = "trainingEventTopic")
    public void processTrainingDeletedEvent(TrainingDeletedEvent event) {
        eventService.addEvent(event);
    }
}
