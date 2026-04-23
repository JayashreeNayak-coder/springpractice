package com.project3.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project3.student_management.dto.StudentRequestDTO;
import com.project3.student_management.dto.StudentResponseDTO;
import com.project3.student_management.service.StudentService;



@RestController
@RequestMapping("/api/student")
public class StudentController {
    
    @Autowired
    private StudentService service;

    //create
    @PostMapping
    public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO dto) {
        return service.CreateStudent(dto);
    }

    //readall
    @GetMapping
    public List<StudentResponseDTO> getAllStudent() {
        return service.GetAllStudent();
    }

    //readbyid
    @GetMapping("/{id}")
    public StudentResponseDTO getStudent(@PathVariable Long id) {
        return service.GetStudentById(id);
    }

    //update
    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable Long id, @RequestBody StudentRequestDTO dto) {

        return service.updateStudent(id, dto);
    }
    
    //deletebyid
    @DeleteMapping("/{id}")
    public StudentResponseDTO deleteStudent(@PathVariable Long id) {
        return service.DeleteStudentById(id);
    }

}
