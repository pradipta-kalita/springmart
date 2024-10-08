package com.springMart.controller;

import com.springMart.dto.category.CategoryRequestDTO;
import com.springMart.dto.category.CategoryResponseDTO;
import com.springMart.service.category.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    // Dependency Injection through constructor
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponseDTO createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO){
        return categoryService.createCategory(categoryRequestDTO);
    }

    @GetMapping
    public List<CategoryResponseDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public CategoryResponseDTO getCategoryById(@PathVariable UUID categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/{categoryId}")
    public  CategoryResponseDTO updateCategoryById(@PathVariable UUID categoryId,@RequestBody CategoryRequestDTO categoryRequestDTO){
        return categoryService.updateCategory(categoryId,categoryRequestDTO);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable UUID categoryId){
        categoryService.deleteCategory(categoryId);
    }

}
