package com.example.feedbackflow.service;

import com.example.feedbackflow.model.Feedback;
import com.example.feedbackflow.repository.FeedbackRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(
            FeedbackRepository feedbackRepository) {

        this.feedbackRepository = feedbackRepository;
    }

    // Add feedback
    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Get all feedback
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    // Get feedback by ID
    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    // Get feedback by course
    public List<Feedback> getFeedbackByCourse(
            Long courseId) {

        return feedbackRepository.findByCourseId(courseId);
    }

    // Get feedback by student
    public List<Feedback> getFeedbackByStudent(
            Long studentId) {

        return feedbackRepository.findByStudentId(studentId);
    }

    // Delete feedback
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}