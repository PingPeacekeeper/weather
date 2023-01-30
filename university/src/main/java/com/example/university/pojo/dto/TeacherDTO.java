package com.example.university.pojo.dto;

import com.example.university.pojo.entity.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TeacherDTO {
    private int TID;
    private String TName;
    private String Display;

    public TeacherDTO(Teacher teacher) {
        this.TID = teacher.getTID();
        this.TName = teacher.getTName();
        this.Display = teacher.getDisplay();
    }
}
