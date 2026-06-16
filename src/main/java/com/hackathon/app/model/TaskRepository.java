package com.hackathon.app.repository;

import com.hackathon.app.model.TaskData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskData, Long> {
}