package com.multiEntity.book_store.utility;

import org.springframework.stereotype.Component;

import com.multiEntity.book_store.dto.authorDTO.AuthorRequestDTO;
import com.multiEntity.book_store.dto.authorDTO.AuthorResponseDTO;
import com.multiEntity.book_store.entity.Author;
import com.multiEntity.book_store.entity.Book;

@Component
public class AuthorMapper {
    
    public AuthorResponseDTO toAuthorResponseDTO(Author author) {

        AuthorResponseDTO response = new AuthorResponseDTO();

        response.setAuthorId(author.getAuthorId());
        response.setAuthorName(author.getAuthorName());
        response.setBookNames(author.getBooks().stream().map(Book::getTitle).toList());

        return response;
    }
    
    public Author toAuthor(AuthorRequestDTO dto) {
        
        Author author = new Author();

        author.setAuthorName(dto.getAuthorName());
      
        return author;
    }
}
