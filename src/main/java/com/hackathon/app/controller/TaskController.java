package com.hackathon.app.controller;

import com.hackathon.app.model.TaskData;
import com.hackathon.app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    // 1. Database & RESTful API: Get all mined data
    @GetMapping
    public List<TaskData> getAllData() {
        return repository.findAll();
    }

    // 2. DM/ML integration: Accept text features, mine values, and predict statuses
    @PostMapping("/predict")
    public TaskData createPrediction(@RequestBody TaskData data) {
        // --- DM / ML DATA ANALYSIS MODULE LAYER ---
        // Tokenize and process incoming data streams to compute an assessment metric
        String text = data.getFeatures() != null ? data.getFeatures().toLowerCase() : "";
        
        // Simple predictive heuristic: analyze feature strings to evaluate operational urgency/risk
        double score = 50.0; // Baseline median score
        if (text.contains("high") || text.contains("urgent") || text.contains("error")) {
            score += 35.5;
        }
        if (text.contains("low") || text.contains("idle") || text.contains("success")) {
            score -= 20.0;
        }
        score += (text.length() % 10); // Feature-length variance mining
        
        // Classification function mapping
        String classificationStatus = (score >= 70.0) ? "CRITICAL/HIGH" : "NORMAL/STABLE";
        
        // Save the analytical insights right back to the DB
        data.setPredictionValue(score);
        data.setStatus(classificationStatus);
        
        return repository.save(data);
    }
}