package com.springpractice.single_entity.repository;

import java.util.List;
import com.springpractice.single_entity.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    List<Todo> findBycompleted(boolean completed);
}
