package com.springpractice.single_entity.controller;

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

    //readbyid
    @GetMapping("/{id}")

    public TodoDTO readTodoDTO(@PathVariable Long id) {

        return service.readByid(id);
    }

    //update
    @PutMapping("/{id}")
    public TodoDTO updateTodoDTO(@PathVariable Long id, @RequestBody TodoDTO dto) {

        return service.updateTodo(id, dto);
    }

    //deleteall
    @DeleteMapping
    public String deleteAllTodo() {

        return service.deleteAll();

    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        
        return service.deleteById(id);
    }

    

}
