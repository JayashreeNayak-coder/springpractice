package com.multiEntity.book_store.utility;


import org.springframework.stereotype.Component;

import com.multiEntity.book_store.dto.bookDTO.BookRequestDTO;
import com.multiEntity.book_store.dto.bookDTO.BookResponseDTO;
import com.multiEntity.book_store.entity.Author;
import com.multiEntity.book_store.entity.Book;

@Component
public class BookMapper {

    
    public BookResponseDTO toBookResponseDTO(Book book) {

        BookResponseDTO response = new BookResponseDTO();

        response.setBookId(book.getBookId());
        response.setTitle(book.getTitle());
        response.setPrice(book.getPrice());

        if (book.getAuthor() != null) {
            response.setAuthorId(book.getAuthor().getAuthorId());
            response.setAuthorName(book.getAuthor().getAuthorName());
        }
         
        return response;
    }
    
    public Book toBookEntity(BookRequestDTO dto,Author author) {

        Book book = new Book();

        book.setTitle(dto.getTitle());
        book.setAuthor(author);
        book.setPrice(dto.getPrice());

        return book;
    }
    

}
