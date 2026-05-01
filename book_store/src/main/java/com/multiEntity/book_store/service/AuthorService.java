package com.multiEntity.book_store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiEntity.book_store.dto.authorDTO.AuthorRequestDTO;
import com.multiEntity.book_store.dto.authorDTO.AuthorResponseDTO;
import com.multiEntity.book_store.entity.Author;
import com.multiEntity.book_store.repository.AuthorRepository;
import com.multiEntity.book_store.utility.AuthorMapper;

@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository authRepo;


    @Autowired
    private AuthorMapper authMapper;

    public AuthorResponseDTO AddNewAuthor(AuthorRequestDTO dto) {

        return authMapper.toAuthorResponseDTO(authRepo.save(authMapper.toAuthor(dto)));
    }
    
    public List<AuthorResponseDTO> ReadAllAuthors() {

        List<Author> authors = authRepo.findAll();
        List<AuthorResponseDTO> responseList = new ArrayList<>();

        for (Author auth : authors) {
            responseList.add(authMapper.toAuthorResponseDTO(auth));
        }

        return responseList;
    }
    
    public AuthorResponseDTO ReadAuthorByID(Long Authid) {

        Author author = authRepo.findById(Authid)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        return authMapper.toAuthorResponseDTO(author);
    }
    
    public AuthorResponseDTO EditAuthorById(Long id, AuthorRequestDTO dto) {

        Author author = authRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        author.setAuthorName(dto.getAuthorName());

        return authMapper.toAuthorResponseDTO(authRepo.save(author));
    }

    public AuthorResponseDTO DeleteAuthor(Long id) {
        Author author = authRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        AuthorResponseDTO deletedAuthor = authMapper.toAuthorResponseDTO(author);

        authRepo.delete(author);

        return deletedAuthor;
    }
    


}
