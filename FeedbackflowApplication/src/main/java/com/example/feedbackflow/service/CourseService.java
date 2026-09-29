package com.example.feedbackflow.service;

import com.example.feedbackflow.model.Course;
import com.example.feedbackflow.repository.CourseRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Add course
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get course by ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Update course
    public Course updateCourse(
            Long id,
            Course course) {

        Optional<Course> existing =
                courseRepository.findById(id);

        if (existing.isPresent()) {

            Course oldCourse = existing.get();

            oldCourse.setCourseName(
                    course.getCourseName()
            );

            oldCourse.setInstructorName(
                    course.getInstructorName()
            );

            oldCourse.setDepartment(
                    course.getDepartment()
            );

            return courseRepository.save(oldCourse);
        }

        return null;
    }

    // Delete course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}