package com.hackathon.app.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "analytics_data")
public class TaskData {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    
    private String features; 
    private Double predictionValue; 
    private String status;

    public Long getId() { return id; } 
    public void setId(Long id) { this.id = id; }
    
    public String getFeatures() { return features; } 
    public void setFeatures(String f) { this.features = f; }
    
    public Double getPredictionValue() { return predictionValue; } 
    public void setPredictionValue(Double p) { this.predictionValue = p; }
    
    public String getStatus() { return status; } 
    public void setStatus(String s) { this.status = s; }
}