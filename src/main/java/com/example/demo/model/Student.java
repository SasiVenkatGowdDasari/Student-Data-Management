package com.example.demo.model;




import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Version;

@Entity
public class Student {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;

    private String name;
    private String email;
    private String course;
    
//    adding new column
    private String city;

    // Constructors
    public Student() {}

    public Student(String name, String email, String course) {
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    
//    adding new getters and setters for new column city
    public String getCity() { return city;}
    public void setCity(String city) { this.city = city; }
}

