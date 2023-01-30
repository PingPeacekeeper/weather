package com.example.university.controller;

import com.example.university.pojo.dto.TeacherDTO;
import com.example.university.pojo.entity.Teacher;
import com.example.university.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    TeacherServiceImpl teacherService;

    @Autowired
    public TeacherController(TeacherServiceImpl service) {
        teacherService = service;
    }

//    @GetMapping("/all")
//    public TeacherResponseDTO getALl() {
//        List<TeacherResponseDTO.TeacherDTO> ls = new ArrayList<>();
//        teacherService.getAll().forEach(tea -> ls.add(new TeacherResponseDTO.TeacherDTO(tea)));
//        return new TeacherResponseDTO(ls);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getStudentByID(@PathVariable Integer id) {
        Teacher teacher = teacherService.getByID(id);
        if (teacher == null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(new TeacherDTO(teacher), HttpStatus.OK);
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Boolean> deleteStudentByID(@PathVariable Integer id) {
//        return new ResponseEntity<>(teacherService.deleteByID(id), HttpStatus.OK);
//    }
//
//    @PostMapping()
//    public ResponseEntity<TeacherResponseDTO> createStudent(@RequestBody Teacher teacher) {
//        Teacher tea = teacherService.create(teacher);
//        return new ResponseEntity<>(new TeacherResponseDTO(List.of(new TeacherResponseDTO.TeacherDTO(tea))), HttpStatus.OK);
//    }
//
//    @PutMapping()
//    public ResponseEntity<TeacherResponseDTO> updateStudent(@RequestBody Teacher teacher) {
//        teacherService.update(teacher);
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<?> handleException() {
//        return new ResponseEntity<>("xxx not found", HttpStatus.NOT_FOUND);
//    }
}