package com.project2.book_management;

import org.springframework.stereotype.Component;

import com.project2.book_management.dto.BookRequestDTO;
import com.project2.book_management.dto.BookResponseDTO;
import com.project2.book_management.entity.Book;

@Component
public class BookMapper {
    
    public Book toEntity(BookRequestDTO dto) {
        Book book = new Book();

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());

        return book;
    }
    public BookResponseDTO toDTO(Book book) {
        BookResponseDTO resdto = new BookResponseDTO();

        resdto.setId(book.getId());
        resdto.setTitle(book.getTitle());
        resdto.setAuthor(book.getAuthor());
        resdto.setPrice(book.getPrice());

        return resdto;
    }

}
