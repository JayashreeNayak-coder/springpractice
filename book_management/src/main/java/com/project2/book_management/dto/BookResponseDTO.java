package com.project2.book_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class BookResponseDTO {
    
    private Long id;
    private String title;
    private String author;
    private Double price;
    
}
