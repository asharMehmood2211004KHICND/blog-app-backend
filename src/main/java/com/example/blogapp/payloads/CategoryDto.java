package com.example.blogapp.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Long categoryId;
    private String categoryTitle;
    private String categoryDescription;
}
