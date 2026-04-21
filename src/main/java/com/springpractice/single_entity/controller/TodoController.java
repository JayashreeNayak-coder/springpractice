package com.springpractice.single_entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.single_entity.dto.TodoDTO;
import com.springpractice.single_entity.service.TodoService;


@RestController
@RequestMapping("/api/todo")
public class TodoController {
    

    @Autowired
    private TodoService service;
    
    //create
    @PostMapping
    public TodoDTO createDto(@RequestBody TodoDTO dto) {

        return service.createtodo(dto);
    }
    
    //read
    @GetMapping
    public List<TodoDTO> reaDtos() {

        return service.readAlltodo();
    }

}
