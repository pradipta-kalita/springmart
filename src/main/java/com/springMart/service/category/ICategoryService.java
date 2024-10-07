package com.springMart.service.category;

import com.springMart.model.Category;

import java.util.List;
import java.util.UUID;


public interface ICategoryService {
    Category getCategoryById(UUID categoryId);
    Category createCategory(Category category);
    void deleteCategory(UUID categoryId);
    Category updateCategory(UUID categoryId);
    List<Category> getAllCategories();
}
