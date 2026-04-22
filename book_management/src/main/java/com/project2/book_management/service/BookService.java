package com.project2.book_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.book_management.BookMapper;
import com.project2.book_management.dto.BookRequestDTO;
import com.project2.book_management.dto.BookResponseDTO;
import com.project2.book_management.entity.Book;
import com.project2.book_management.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository repo;

    @Autowired
    private BookMapper mapper;

    //create
    public BookResponseDTO CreateBook(BookRequestDTO dto) {

        Book book = mapper.toEntity(dto);
        Book saved = repo.save(book);

        return mapper.toDTO(saved);
    }
    
    //readAll
    public List<BookResponseDTO> GetAllBook() {

        List<BookResponseDTO> resdto = new ArrayList<>();

        for (Book i : repo.findAll()) {
            resdto.add(mapper.toDTO(i));
        }
        return resdto;
    }
    
    //readByid
    public BookResponseDTO GetBookById(Long id) {

        Book book = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return mapper.toDTO(book);
    }
    //update
    public BookResponseDTO UpdateBook(Long id, BookRequestDTO dto) {

        Book book = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());

        repo.save(book);

        return mapper.toDTO(book);
    }
    //deleteBook
    public String DeleteBook(Long id) {
        
         repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

         repo.deleteById(id);
        
         return "book deleted";

    }
}
