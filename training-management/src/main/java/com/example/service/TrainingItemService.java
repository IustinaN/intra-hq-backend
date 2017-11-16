package com.example.service;

import com.example.kafka.EventProducer;
import com.example.mongoDb.model.*;
import com.example.mongoDb.repository.TrainingCatalogueRepository;
import com.example.mongoDb.repository.TrainingItemRepository;
import com.example.mongoDb.repository.TrainingRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrainingItemService {

    @Autowired
    private TrainingItemRepository trainingItemRepository;

    @Autowired
    private TrainingCatalogueRepository trainingCatalogueRepository;

    @Autowired
    private TrainingRequestRepository trainingRequestRepository;

    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private EventService eventService;

    public TrainingItem find(String name) {
        return trainingItemRepository.findByName(name);
    }

    public List<TrainingItem> getAllTrainingItems() {
        return trainingItemRepository.findAll();
    }

    public TrainingCatalogue addTrainingCatalogue(TrainingCatalogue trainingCatalogue) {
        return trainingCatalogueRepository.save(trainingCatalogue);
    }

    /**
     * Only new AVAILABLE training item is added to the training catalog
     *
     * @param trainingItem
     * @throws IllegalArgumentException
     */
    @Transactional
    public void addTrainingItemAndUpdateCatalogue(TrainingItem trainingItem) throws IllegalArgumentException {
        List<TrainingCatalogue> trainingCatalogues = trainingCatalogueRepository.findAll();

        if (trainingCatalogues.isEmpty()) {
            throw new IllegalArgumentException("Create a trainingCatalog before adding a training item to it");
        }

        TrainingItem newTrainingItem = trainingItemRepository.save(trainingItem);
            List<TrainingItem> trainingItems = trainingCatalogues.get(0).getTrainingItems() != null ? trainingCatalogues.get(0).getTrainingItems() : new ArrayList<>();
            trainingItems.add(newTrainingItem);
            trainingCatalogues.get(0).setTrainingItems(trainingItems);
            trainingCatalogueRepository.save(trainingCatalogues.get(0));
    }

    /**
     * A training request can be added only if the employee is allowed
     * a maximum of 2 training requests per employee can be placed
     *
     * @param trainingRequest
     * @return
     * @throws IllegalArgumentException
     */
    public TrainingRequest addTrainingRequest(TrainingRequest trainingRequest) throws IllegalArgumentException {
        Employee employee = trainingRequest.getEmployee();

        if (!isTrainingRequestAllowedForEmployee(employee)) {
            throw new IllegalArgumentException("Maximum number of training requests reached for employee: " + employee.getName());
        }

        return trainingRequestRepository.save(trainingRequest);
    }

    /**
     * remove training item, remove it also from training catalog & check for training requests?
     *
     * @param trainingItem
     */
    @Transactional
    public void deleteTrainingItem(TrainingItem trainingItem) {
        trainingItemRepository.deleteById(trainingItem.getTrainingItemId());
    }

    private boolean isTrainingRequestAllowedForEmployee(Employee employee) {
        return trainingRequestRepository.getTrainingRequestsNumberPerEmployee(employee.getName()) < 2;
    }
}
