package com.example.university.repositories;


import com.example.university.pojo.entity.Teacher_Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherStudentRepository extends CrudRepository<Teacher_Student, Integer> {



}
