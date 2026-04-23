package com.project3.student_management.utility;


import org.springframework.stereotype.Component;

import com.project3.student_management.dto.StudentRequestDTO;
import com.project3.student_management.dto.StudentResponseDTO;
import com.project3.student_management.entity.Student;

@Component
public class Mapper {
    
    public Student toEntity(StudentRequestDTO dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());

        return student;
    }
    
    public StudentResponseDTO toDTO(Student student) {
        
        StudentResponseDTO dto = new StudentResponseDTO();

        dto.setId(student.getId());
        dto.setCourse(student.getCourse());
        dto.setEmail(student.getEmail());
        dto.setName(student.getName());

        return dto;
    }

}
