package com.example.university.pojo.dto;



import com.example.university.pojo.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class TeacherResponseDTO {
    private List<TeacherDTO> list;


}