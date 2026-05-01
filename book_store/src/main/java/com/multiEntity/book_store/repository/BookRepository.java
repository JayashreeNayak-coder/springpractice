package com.multiEntity.book_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiEntity.book_store.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    
}
