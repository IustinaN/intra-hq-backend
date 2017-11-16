package com.example.postgreSql.repository;

import com.example.postgreSql.model.Training;
import org.springframework.data.repository.CrudRepository;

public interface TrainingRepository extends CrudRepository<Training, Long> {
}
