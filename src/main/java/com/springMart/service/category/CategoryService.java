package com.springMart.service.category;

import com.springMart.model.Category;

import java.util.List;
import java.util.UUID;

public class CategoryService implements ICategoryService{
    @Override
    public Category getCategoryById(UUID categoryId) {
        return null;
    }

    @Override
    public Category createCategory(Category category) {
        return null;
    }

    @Override
    public void deleteCategory(UUID categoryId) {

    }

    @Override
    public Category updateCategory(UUID categoryId) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }
}
