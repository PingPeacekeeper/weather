package com.example.university.service.impl;


import com.example.university.pojo.entity.Student;
import com.example.university.repositories.StudentRepository;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repo) {
        this.repository = repo;
    }

    @Override
    public Iterable<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student getByID(int id) {
        Optional<Student> student = repository.findById(id);
        return student.orElse(null);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Boolean deleteByID(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public Student create(Student student) {
        return repository.save(student);
    }


}