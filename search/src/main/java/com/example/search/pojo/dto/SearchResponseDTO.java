package com.example.search.pojo.dto;

import com.example.provider.pojo.dto.ProviderDTO;
import com.example.university.pojo.dto.StudentDTO;
import com.example.university.pojo.dto.TeacherDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class SearchResponseDTO {
    private ProviderDTO providerDTO;
    private TeacherDTO teacherDTO;
    private StudentDTO studentDTO;
}
