package com.example.feedbackflow.controller;

import com.example.feedbackflow.model.Course;
import com.example.feedbackflow.service.CourseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    private final CourseService courseService;

    public CourseController(
            CourseService courseService) {

        this.courseService = courseService;
    }

    // POST /api/courses
    @PostMapping
    public ResponseEntity<Course> addCourse(
            @RequestBody Course course) {

        Course savedCourse =
                courseService.addCourse(course);

        return new ResponseEntity<>(
                savedCourse,
                HttpStatus.CREATED
        );
    }

    // GET /api/courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {

        return ResponseEntity.ok(
                courseService.getAllCourses()
        );
    }

    // GET /api/courses/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(
            @PathVariable Long id) {

        Optional<Course> course =
                courseService.getCourseById(id);

        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        }

        return ResponseEntity.notFound().build();
    }

    // PUT /api/courses/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable Long id,
            @RequestBody Course course) {

        Course updatedCourse =
                courseService.updateCourse(id, course);

        if (updatedCourse != null) {
            return ResponseEntity.ok(updatedCourse);
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE /api/courses/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(
            @PathVariable Long id) {

        courseService.deleteCourse(id);

        return ResponseEntity.ok(
                "Course deleted successfully"
        );
    }
}