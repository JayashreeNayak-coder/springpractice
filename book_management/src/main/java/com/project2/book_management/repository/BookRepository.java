package com.project2.book_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2.book_management.entity.Book;



public interface BookRepository extends JpaRepository<Book,Long>{
    
}
