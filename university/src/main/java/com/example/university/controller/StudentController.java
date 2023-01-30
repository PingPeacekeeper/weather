package com.example.university.controller;


import com.example.university.pojo.dto.StudentDTO;
import com.example.university.pojo.dto.StudentResponseDTO;
import com.example.university.pojo.entity.Student;
import com.example.university.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl service) {
        studentService = service;
    }

//    @GetMapping("/all")
//    public StudentResponseDTO getALl() {
//        List<StudentResponseDTO.StudentDTO> ls = new ArrayList<>();
//        studentService.getAll().forEach(stu -> ls.add(new StudentResponseDTO.StudentDTO(stu)));
//        return new StudentResponseDTO(ls);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentByID(@PathVariable Integer id) {
        Student student = studentService.getByID(id);
        if (student == null) {
            System.out.println("null");
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        System.out.println(student);
        return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Boolean> deleteStudentByID(@PathVariable Integer id) {
//        return new ResponseEntity<>(studentService.deleteByID(id), HttpStatus.OK);
//    }
//
//    @PostMapping()
//    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody Student student) {
//        Student stu = studentService.create(student);
//        return new ResponseEntity<>(new StudentResponseDTO(List.of(new StudentResponseDTO.StudentDTO(stu))), HttpStatus.OK);
//    }
//
//    @PutMapping()
//    public ResponseEntity<StudentResponseDTO> updateStudent(@RequestBody Student student) {
//        studentService.update(student);
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }

}