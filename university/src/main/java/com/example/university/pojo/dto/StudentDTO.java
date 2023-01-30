package com.example.university.pojo.dto;

import com.example.university.pojo.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public  class StudentDTO{
    private int SID;
    private String SName;
    private String Display;

    public StudentDTO(Student student){
        this.SID=student.getSID();
        this.SName=student.getSName();
        this.Display=student.getDisplay();
    }
}
