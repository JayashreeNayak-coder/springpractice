package com.multiEntity.book_store.dto.bookDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDTO {
    private Long BookId;
    private String title;
    private Double price;
    private Long AuthorId;
    private String AuthorName;
}
