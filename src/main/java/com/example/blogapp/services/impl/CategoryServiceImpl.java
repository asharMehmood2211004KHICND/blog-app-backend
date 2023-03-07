package com.example.blogapp.services.impl;

import com.example.blogapp.entities.Category;
import com.example.blogapp.exceptions.ResourceNotFoundException;
import com.example.blogapp.payloads.CategoryDto;
import com.example.blogapp.repositories.CategoryRepo;
import com.example.blogapp.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCategory=this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCatergoryDescription(categoryDto.getCategoryDescription());
        Category updatedcat=this.categoryRepo.save(cat);
        return this.modelMapper.map(updatedcat,CategoryDto.class);


    }

    @Override
    public void deleteCategory(Long categoryId) {
    Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
    this.categoryRepo.deleteById(categoryId);
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
       return this.modelMapper.map(cat,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
       List<CategoryDto> categoryDtos =  categories.stream().map(cat->modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
       return  categoryDtos;

    }
}