package com.multiEntity.book_store.dto.bookDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO {
    private String title;
    private Long AuthorId;
    private Double price;
}
