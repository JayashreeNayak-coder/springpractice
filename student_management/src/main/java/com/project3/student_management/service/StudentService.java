package com.project3.student_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project3.student_management.dto.StudentRequestDTO;
import com.project3.student_management.dto.StudentResponseDTO;
import com.project3.student_management.entity.Student;
import com.project3.student_management.repository.StudentRepository;
import com.project3.student_management.utility.Mapper;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    @Autowired
    private Mapper map;

    //create
    public StudentResponseDTO CreateStudent(StudentRequestDTO dto) {

        Student NewStudent = map.toEntity(dto);
        Student saved = repo.save(NewStudent);

        return map.toDTO(saved);
    }
    
    //readall
    public List<StudentResponseDTO> GetAllStudent() {

        List<StudentResponseDTO> list = new ArrayList<>();

        for (Student i : repo.findAll()) {
            list.add(map.toDTO(i));
        }

        return list;
    }
    //readbyid
    public StudentResponseDTO GetStudentById(Long id) {

        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return map.toDTO(student);

    }
    //update
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setCourse(dto.getCourse());
        student.setEmail(dto.getEmail());

        Student saved = repo.save(student);

        return map.toDTO(saved);
    }
    
    //delete
    public StudentResponseDTO DeleteStudentById(Long id) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        StudentResponseDTO deletedstudent = map.toDTO(student);

        repo.delete(student);

        return deletedstudent;
    }
}
