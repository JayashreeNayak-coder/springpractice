package com.multiEntity.book_store.dto.authorDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponseDTO {
    
    private Long AuthorId;
    private String AuthorName;
    private List<String> bookNames; 
}
