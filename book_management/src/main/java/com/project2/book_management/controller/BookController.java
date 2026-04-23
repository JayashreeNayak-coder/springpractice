package com.project2.book_management.controller;


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

import com.project2.book_management.dto.BookRequestDTO;
import com.project2.book_management.dto.BookResponseDTO;
import com.project2.book_management.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
    
    @Autowired
    private BookService service;

    //create
    @PostMapping
    public BookResponseDTO createBook(@RequestBody BookRequestDTO dto) {

        return service.CreateBook(dto);
    }
    
    //readall
    @GetMapping
    public List<BookResponseDTO> getAllBook() {

        return service.GetAllBook();
    }
    
    //readByid
    @GetMapping("/{id}")
    public BookResponseDTO getBookById(@PathVariable Long id) {

        return service.GetBookById(id);
    }
    
    //update
    @PutMapping("/{id}")
    public BookResponseDTO updateBook(@PathVariable Long id, @RequestBody BookRequestDTO dto) {

        return service.UpdateBook(id, dto);
    }

    //deletebook
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        
        return service.DeleteBook(id);
    }
    
    
}
