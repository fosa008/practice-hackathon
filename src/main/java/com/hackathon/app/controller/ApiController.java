package com.hackathon.app.controller;

import com.hackathon.app.model.TaskData;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List; 
import java.util.Arrays;

@RestController 
@RequestMapping("/api") 
@CrossOrigin(origins = "*")
public class ApiController {

    @PersistenceContext 
    private EntityManager entityManager;

    @GetMapping("/records") 
    public List<TaskData> getAllRecords() {
        return entityManager.createQuery("SELECT t FROM TaskData t", TaskData.class).getResultList();
    }

    @PostMapping("/predict") 
    @Transactional 
    public TaskData processAndPredict(@RequestBody TaskData input) {
        double calculation = Arrays.stream(input.getFeatures().split(","))
                                   .mapToDouble(Double::parseDouble)
                                   .average()
                                   .orElse(0.0);
                                   
        String targetClassification = (calculation > 50.0) ? "HIGH RISK / PRIORITY" : "NORMAL / STABLE";
        
        TaskData entity = new TaskData(); 
        entity.setFeatures(input.getFeatures()); 
        entity.setPredictionValue(calculation); 
        entity.setStatus(targetClassification);
        
        entityManager.persist(entity); 
        return entity;
    }
}