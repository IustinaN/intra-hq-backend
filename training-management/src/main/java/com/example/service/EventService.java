package com.example.service;

import com.example.events.CustomEvent;
import com.example.events.Event;
import com.example.mongoDb.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<CustomEvent> getAllEvents() {
        return eventRepository.findAll();
    }

    public CustomEvent addEvent(CustomEvent event){
        return eventRepository.save(event);
    }
}
