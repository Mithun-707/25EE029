package com.example.feedbackflow.service;

import com.example.feedbackflow.model.Student;
import com.example.feedbackflow.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Add student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Update student
    public Student updateStudent(
            Long id,
            Student student) {

        Optional<Student> existing =
                studentRepository.findById(id);

        if (existing.isPresent()) {

            Student oldStudent = existing.get();

            oldStudent.setStudentName(
                    student.getStudentName()
            );

            oldStudent.setEmail(
                    student.getEmail()
            );

            oldStudent.setDepartment(
                    student.getDepartment()
            );

            return studentRepository.save(oldStudent);
        }

        return null;
    }

    // Delete student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}