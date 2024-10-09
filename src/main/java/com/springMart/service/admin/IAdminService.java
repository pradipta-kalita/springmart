package com.springMart.service.admin;

import com.springMart.model.Category;
import com.springMart.model.Product;
import com.springMart.model.admin.Admin;

import java.util.List;
import java.util.UUID;

public interface IAdminService {
    List<Category> getAllCategories();
    Category createCategory(Category category);
    void deleteCategory(UUID categoryId);
    Category updateCategory(UUID categoryId,Category category);

    Product createProduct(Product product);
    Product updateProduct(UUID productId,Product product);
    void deleteProduct(UUID productId);

    Admin createAdmin(Admin admin);
}
