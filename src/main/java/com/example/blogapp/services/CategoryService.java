package com.example.blogapp.services;

import com.example.blogapp.entities.Category;
import com.example.blogapp.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //methods are by deafult public in interfaces
    //interfaces are used for loose cupoling , implementation can be changed at any time

     CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto,Long categoryId);

     CategoryDto getCategory(Long categoryId);
    void deleteCategory (Long categoryId);

     List<CategoryDto> getCategories();




}
