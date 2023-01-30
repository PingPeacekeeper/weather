package com.example.university.config;

import com.example.university.pojo.dto.StudentDTO;
import com.example.university.pojo.dto.TeacherDTO;
import com.example.university.pojo.entity.Student;
import com.example.university.pojo.entity.Teacher;
import com.example.university.pojo.entity.Teacher_Student;
import org.springframework.context.annotation.Import;

@Import({Student.class, Teacher.class, Teacher_Student.class, StudentDTO.class, TeacherDTO.class})
public @interface EnableUniversity {

}
