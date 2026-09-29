package com.example.feedbackflow.repository;

import com.example.feedbackflow.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    List<Feedback> findByCourseId(Long courseId);

    List<Feedback> findByStudentId(Long studentId);
}