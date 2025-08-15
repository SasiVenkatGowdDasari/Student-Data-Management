package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Read all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Read student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Update student
    public Student updateStudent(Long id, Student updatedDetails) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        
        existingStudent.setName(updatedDetails.getName());
        existingStudent.setEmail(updatedDetails.getEmail());
        existingStudent.setCourse(updatedDetails.getCourse());
        
//        adding new column city
        existingStudent.setCity(updatedDetails.getCity());

        // Save the managed entity (NOT the incoming one)
        return studentRepository.save(existingStudent);
    }


    // Delete student
    public boolean deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
