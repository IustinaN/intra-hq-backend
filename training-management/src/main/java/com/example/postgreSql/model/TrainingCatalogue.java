package com.example.postgreSql.model;

import javax.persistence.*;
import java.util.List;
//
//@Entity
//@Table(name = "training_catalogue")
//public class TrainingCatalogue {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "training_catalog_id")
//    private String id;
//
//    @OneToMany(targetEntity= Training.class, fetch=FetchType.EAGER)
////    @JoinColumn(name="training_catalog_id")
//    private List<Training> PSTrainingItems;
//    private String owner;
//    private String lastUpdated;
//
//    public TrainingCatalogue() {
//    }
//
//    public List<Training> getPSTrainingItems() {
//        return PSTrainingItems;
//    }
//
//    public void setPSTrainingItems(List<Training> PSTrainingItems) {
//        this.PSTrainingItems = PSTrainingItems;
//    }
//
//    public void setOwner(String owner) {
//        this.owner = owner;
//    }
//
//    public void setLastUpdated(String lastUpdated) {
//        this.lastUpdated = lastUpdated;
//    }
//}
