package com.springpractice.single_entity.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class TodoDTO {
    
    private String name;
    private String description;
    private boolean completed;
}
