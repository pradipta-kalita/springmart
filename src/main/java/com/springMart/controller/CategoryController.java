package com.springMart.controller;

import com.springMart.model.Category;
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
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable UUID categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/{categoryId}")
    public  Category updateCategoryById(@PathVariable UUID categoryId,@RequestBody Category category){
        return categoryService.updateCategory(categoryId,category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable UUID categoryId){
        categoryService.deleteCategory(categoryId);
    }

}
