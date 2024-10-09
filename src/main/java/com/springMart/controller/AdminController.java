package com.springMart.controller;

import com.springMart.model.Category;
import com.springMart.model.Product;
import com.springMart.model.admin.Admin;
import com.springMart.service.admin.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return adminService.getAllCategories();
    }

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody @Valid Admin admin) {
        Admin ResponseAdmin = adminService.createAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseAdmin);
    }


    // Create a new category
    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody @Valid Category category){
        Category createdCategory = adminService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    // Update a category
    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable UUID categoryId, @RequestBody @Valid Category category) {
        return ResponseEntity.ok(adminService.updateCategory(categoryId, category));
    }

    // Delete a category
    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable UUID categoryId) {
        adminService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }

    // Create a new product
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody @Valid Product product) {
        adminService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
    }

    // Update a product
    @PutMapping("/products/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable UUID productId, @RequestBody @Valid Product product) {
        adminService.updateProduct(productId, product);
        return ResponseEntity.ok("Product updated successfully");
    }

    // Delete a product
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID productId) {
        adminService.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
