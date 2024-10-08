package com.springMart.service.admin;

import com.springMart.model.Category;
import com.springMart.model.Product;
import com.springMart.model.admin.Admin;

import java.util.UUID;

public interface IAdminService {
    void createCategory(Category category);
    void deleteCategory(UUID categoryId);
    void updateCategory(UUID categoryId,Category category);

    void createProduct(Product product);
    void updateProduct(UUID productId,Product product);
    void deleteProduct(UUID productId);

    Admin createAdmin(Admin admin);
}
