package com.example.blogapp.controllers;

import com.example.blogapp.payloads.ApiResponse;
import com.example.blogapp.payloads.CategoryDto;
import com.example.blogapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto ,
                                                      @PathVariable Long catId ){
        CategoryDto updatdeCategory = this.categoryService.updateCategory(categoryDto,catId);
        return new ResponseEntity<CategoryDto>(updatdeCategory,HttpStatus.OK);
    }

    @DeleteMapping("/{catId}")
    public  ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long catId){
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted",true),HttpStatus.OK);

    }

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long catId){
        CategoryDto categoryDto = this.categoryService.getCategory(catId);
        return  new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categoryDtos = categoryService.getCategories();
        return new  ResponseEntity<List<CategoryDto>>(categoryDtos,HttpStatus.OK);
    }


}
