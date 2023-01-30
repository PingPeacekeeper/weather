package com.example.university.service;

import com.example.university.pojo.entity.Teacher;

public interface TeacherService {

    Iterable<Teacher> getAll();

    Teacher getByID(int id);

    Boolean deleteByID(int id);

    Teacher update(Teacher teacher);

    Teacher create(Teacher teacher);

}