package com.example.mongoDb.demo;

import com.example.mongoDb.demo.model.Training;
import com.example.mongoDb.demo.service.TrainingService;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private TrainingService trainingService;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //removes the  _class when adding a new Training
    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory,
                                       MongoMappingContext context) {

        MappingMongoConverter converter =
            new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);

        return mongoTemplate;

    }


    @Override
    public void run(String... args) throws Exception {
        Training newTraining = new Training("Training13", "Some description13",
            "true", "17/02/2018", "available", 100);
        System.out.println(trainingService.addNewTraining(newTraining));
    }
}

