package com.multiEntity.book_store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiEntity.book_store.dto.bookDTO.BookRequestDTO;
import com.multiEntity.book_store.dto.bookDTO.BookResponseDTO;
import com.multiEntity.book_store.entity.Author;
import com.multiEntity.book_store.entity.Book;
import com.multiEntity.book_store.repository.AuthorRepository;
import com.multiEntity.book_store.repository.BookRepository;
import com.multiEntity.book_store.utility.BookMapper;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookrepo;

    @Autowired
    private AuthorRepository authrepo;

    @Autowired
    private BookMapper bookmapper;

    public BookResponseDTO AddNewBook(BookRequestDTO dto) {

        Author author = authrepo.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        return bookmapper.toBookResponseDTO(bookrepo.save(bookmapper.toBookEntity(dto, author)));
    }
    
    public List<BookResponseDTO> ReadBooks() {

        List<Book> bookEntities = bookrepo.findAll();
        List<BookResponseDTO> responseList = new ArrayList<>();

        for (Book book : bookEntities) {
            responseList.add(bookmapper.toBookResponseDTO(book));
        }
        return responseList;
    }
     
    public BookResponseDTO ReadBookById(Long id) {

        Book book = bookrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return bookmapper.toBookResponseDTO(book);
    }
    
    public BookResponseDTO EditBook(Long id, BookRequestDTO dto) {

        Book book = bookrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
                
        book.setTitle(dto.getTitle());
        book.setPrice(dto.getPrice());

        Author oldAuthor = book.getAuthor();
            if (oldAuthor != null) {
                oldAuthor.getBooks().remove(book);
            }

            Author newAuthor = authrepo.findById(dto.getAuthorId())
                        .orElseThrow(() -> new RuntimeException("Author not found"));

            book.setAuthor(newAuthor);
            newAuthor.getBooks().add(book);

    return bookmapper.toBookResponseDTO(bookrepo.save(book));
    }


    public BookResponseDTO DeleteBook(Long id) {
         Book book = bookrepo.findById(id)
                 .orElseThrow(() -> new RuntimeException("Book not found"));
                
         BookResponseDTO deletedbook = bookmapper.toBookResponseDTO(book);

         Author author = book.getAuthor();

          if (author != null) {
            author.getBooks().remove(book);
        }
         bookrepo.delete(book);

    return deletedbook;
     }
    

}
