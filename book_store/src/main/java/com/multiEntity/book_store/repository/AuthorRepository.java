package com.multiEntity.book_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiEntity.book_store.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}

 