package com.example.postgreSql.model;

import com.example.mongoDb.model.Mandatory;
import com.example.mongoDb.model.TrainingType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "trainings")
@Getter @Setter
public class Training implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainingId;
    private String name;
    private String description;
    private TrainingType type;
    private Mandatory mandatory;
    private Integer noOfPoints;
    private String provider;
    private String startDate;
    private String endDate;

    public Training() {
    }

    @Override
    public String toString() {
        return String.format("Training[trainingId=%s, name='%s', description='%s', type='%s', mandatory='%s', " +
                        "noOfPoints='%s', provider='%s', startDate='%s', endDate='%s']",
                trainingId, name, description, type, mandatory,
                noOfPoints, provider, startDate, endDate);
    }
}
