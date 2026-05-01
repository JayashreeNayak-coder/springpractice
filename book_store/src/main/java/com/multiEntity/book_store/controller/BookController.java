package com.multiEntity.book_store.controller;

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

import com.multiEntity.book_store.dto.bookDTO.BookRequestDTO;
import com.multiEntity.book_store.dto.bookDTO.BookResponseDTO;
import com.multiEntity.book_store.service.BookService;

@RestController
@RequestMapping("/book_store/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public BookResponseDTO AddNewBook(@RequestBody BookRequestDTO dto) {
        return bookService.AddNewBook(dto);
    }

    @GetMapping
    public List<BookResponseDTO> ReadAllBooks() {
        return bookService.ReadBooks();
    }

    @GetMapping("/{id}")
    public BookResponseDTO ReadBookByID(@PathVariable Long id) {
        return bookService.ReadBookById(id);
    }

    @PutMapping("/{id}")
    public BookResponseDTO EditBook(@PathVariable Long id, @RequestBody BookRequestDTO dto) {
        return bookService.EditBook(id, dto);
    }

    @DeleteMapping("/{id}")
    public BookResponseDTO DeleteBook(@PathVariable Long id) {
        return bookService.DeleteBook(id);
    }

    
}
