package com.springMart.service.category;

import com.springMart.model.Category;
import com.springMart.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;

    // Dependency Injection through Constructor
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


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
    public Category updateCategory(UUID categoryId, Category category) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }
}
