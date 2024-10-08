package com.springMart.controller;

import com.springMart.model.Product;
import com.springMart.service.product.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    // Dependency Injection through Constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
    @PostMapping(consumes = "multipart/form-data")
    public Product createProduct(@ModelAttribute Product product){
        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable UUID productId){
        return productService.getProductById(productId);
    }

    @PutMapping("/{productId}")
    public Product updateProductById(@PathVariable UUID productId,@RequestBody Product product){
        return productService.updateProduct(productId,product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable UUID productId){
        productService.deleteProduct(productId);
    }
}
