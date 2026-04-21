package com.springpractice.single_entity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpractice.single_entity.dto.TodoDTO;
import com.springpractice.single_entity.entity.Todo;
import com.springpractice.single_entity.repository.TodoRepository;

@Service
public class TodoService {
    
    @Autowired
    private TodoRepository todorepo;

    //create
    public TodoDTO createtodo(TodoDTO dto) {

        Todo obj = new Todo();
        obj.setName(dto.getName());
        obj.setDescription(dto.getDescription());
        obj.setCompleted(false);

        todorepo.save(obj);

        TodoDTO resdto = new TodoDTO();
        resdto.setName(obj.getName());
        resdto.setDescription(obj.getDescription());
        resdto.setCompleted(obj.isCompleted());

        return resdto;

    }
    
    //read
    public List<TodoDTO> readAlltodo() {

        List<TodoDTO> res = new ArrayList<>();

        for (Todo i : todorepo.findAll()) {

            TodoDTO dto = new TodoDTO();
            dto.setName(i.getName());
            dto.setDescription(i.getDescription());
            dto.setCompleted(i.isCompleted());

            res.add(dto);

        }
        return res;
    }

}
