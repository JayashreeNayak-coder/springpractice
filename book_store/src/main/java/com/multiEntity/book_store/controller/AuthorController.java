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

import com.multiEntity.book_store.dto.authorDTO.AuthorRequestDTO;
import com.multiEntity.book_store.dto.authorDTO.AuthorResponseDTO;
import com.multiEntity.book_store.service.AuthorService;

@RestController
@RequestMapping("/book_store/author")
public class AuthorController {
    

    @Autowired
    private AuthorService authService;

    @PostMapping
    public AuthorResponseDTO AddNewAuthor(@RequestBody AuthorRequestDTO dto) {

        return authService.AddNewAuthor(dto);
    }
    
    @GetMapping
    public List<AuthorResponseDTO> ReadAllAuthor() {
        return authService.ReadAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorResponseDTO ReadAuthorID(@PathVariable Long id) {
        return authService.ReadAuthorByID(id);

    }

    @PutMapping("/{id}")
    public AuthorResponseDTO EditAuthorById(@PathVariable Long id, @RequestBody AuthorRequestDTO dto) {
        return authService.EditAuthorById(id, dto);
    }

    @DeleteMapping("/{id}")
    public AuthorResponseDTO DeleteAuthor(@PathVariable Long id) {
        return authService.DeleteAuthor(id);
     }
    
        
    

}
