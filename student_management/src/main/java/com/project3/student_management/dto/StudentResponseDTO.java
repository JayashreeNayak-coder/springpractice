package com.project3.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentResponseDTO {
    

    private Long id;
    private String email;
    private String name;
    private String course;
}
