package com.example.kafka;

import com.example.events.CustomEvent;
import com.example.events.Event;
import com.example.events.TrainingCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class EventProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendEvent(CustomEvent event){
        kafkaTemplate.sendDefault(event);
    }
}
