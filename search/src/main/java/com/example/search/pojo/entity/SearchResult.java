package com.example.search.pojo.entity;

import com.example.provider.pojo.dto.ProviderDTO;
import com.example.provider.pojo.entity.Provider;
import com.example.university.pojo.dto.StudentDTO;
import com.example.university.pojo.dto.TeacherDTO;
import com.example.university.pojo.entity.Student;
import com.example.university.pojo.entity.Teacher;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class SearchResult {
    private ProviderDTO providerDTO;
    private TeacherDTO teacherDTO;
    private StudentDTO studentDTO;

}
