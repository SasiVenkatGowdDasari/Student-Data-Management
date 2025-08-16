package com.example.demo.exception;

public class StudentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(Long id) {
		super ("Student with id "+ id +" does not exist");
	}
}
