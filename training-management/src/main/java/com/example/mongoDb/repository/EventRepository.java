package com.example.mongoDb.repository;

import com.example.events.CustomEvent;
import com.example.events.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<CustomEvent, String>, MongoRepository<CustomEvent, String> {
}
