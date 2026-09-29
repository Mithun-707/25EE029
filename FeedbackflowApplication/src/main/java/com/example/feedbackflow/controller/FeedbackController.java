package com.example.feedbackflow.controller;

import com.example.feedbackflow.model.Feedback;
import com.example.feedbackflow.service.FeedbackService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(
            FeedbackService feedbackService) {

        this.feedbackService = feedbackService;
    }

    // POST /api/feedback
    @PostMapping
    public ResponseEntity<Feedback> addFeedback(
            @RequestBody Feedback feedback) {

        Feedback savedFeedback =
                feedbackService.addFeedback(feedback);

        return new ResponseEntity<>(
                savedFeedback,
                HttpStatus.CREATED
        );
    }

    // GET /api/feedback
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {

        return ResponseEntity.ok(
                feedbackService.getAllFeedback()
        );
    }

    // GET /api/feedback/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(
            @PathVariable Long id) {

        Optional<Feedback> feedback =
                feedbackService.getFeedbackById(id);

        if (feedback.isPresent()) {
            return ResponseEntity.ok(feedback.get());
        }

        return ResponseEntity.notFound().build();
    }

    // GET /api/feedback/course/{courseId}
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Feedback>> getByCourse(
            @PathVariable Long courseId) {

        return ResponseEntity.ok(
                feedbackService.getFeedbackByCourse(courseId)
        );
    }

    // GET /api/feedback/student/{studentId}
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Feedback>> getByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                feedbackService.getFeedbackByStudent(studentId)
        );
    }

    // DELETE /api/feedback/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(
            @PathVariable Long id) {

        feedbackService.deleteFeedback(id);

        return ResponseEntity.ok(
                "Feedback deleted successfully"
        );
    }
}