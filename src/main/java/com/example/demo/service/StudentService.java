package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create student
    public Student saveStudent(Student student) {
    	 // Auto-generate ID: find greatest current ID and add 1
    	if (student.getId()==null) {
    		Long maxId=studentRepository.findAll().stream().mapToLong(Student::getId).max().orElse(0L);
    		student.setId(maxId+1);
    	}
    	 // If ID is provided, use it directly.
        return studentRepository.save(student);
    }

    // Read all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Read student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }	

    // Update student
    public Student updateStudent(Long id, Student updatedDetails) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        
        existingStudent.setName(updatedDetails.getName());
        existingStudent.setEmail(updatedDetails.getEmail());
        existingStudent.setCourse(updatedDetails.getCourse());
        
//        adding new column city
        existingStudent.setCity(updatedDetails.getCity());

        // Save the managed entity (NOT the incoming one)
        return studentRepository.save(existingStudent);
    }


    // Delete student
    public Student deleteStudent(Long id) {
    	Student st=studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
    	return st;
    }
}
