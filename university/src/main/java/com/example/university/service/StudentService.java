package com.example.university.service;

import com.example.university.pojo.entity.Student;
import com.example.university.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface StudentService {
    Iterable<Student> getAll();

    Student getByID(int id);

    Boolean deleteByID(int id);

    Student update(Student student);

    Student create(Student student);
}