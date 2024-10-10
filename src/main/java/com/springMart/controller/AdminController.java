package com.springMart.controller;

import com.springMart.dto.ProductRequestDTO;
import com.springMart.model.Category;
import com.springMart.model.Product;
import com.springMart.model.admin.Admin;
import com.springMart.service.admin.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    // Delete an admin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable UUID id){
        adminService.deleteAdmin(id);
        return ResponseEntity.ok().body("Account successfully deleted.");
    }

    // Create an admin
    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody @Valid Admin admin) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.createAdmin(admin));
    }

    // Get all categories
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return adminService.getAllCategories();
    }

    // Create a new category
    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody @Valid Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.createCategory(category));
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
        return ResponseEntity.ok().body("Category deleted successfully");
    }

    // Get all products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(adminService.getAllProducts());
    }
    // Create a new product
    @PostMapping(value = "/products",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Product> createProduct(@ModelAttribute @Valid ProductRequestDTO product) {
        System.out.println("Entered Controller");
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.createProduct(product));
    }

    // Update a product
    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID productId, @RequestBody @Valid Product product) {
        return ResponseEntity.ok().body(adminService.updateProduct(productId, product));
    }

    // Delete a product
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID productId) {
        adminService.deleteProduct(productId);
        return ResponseEntity.ok().body("Product deleted successfully");
    }
}
