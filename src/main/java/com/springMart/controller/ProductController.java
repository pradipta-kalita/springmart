package com.springMart.controller;

import com.springMart.dto.product.ProductRequestDTO;
import com.springMart.dto.product.ProductResponseDTO;
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

    @PostMapping
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        return productService.createProduct(productRequestDTO);
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ProductResponseDTO getProductById(@PathVariable UUID productId){
        return productService.getProductById(productId);
    }

    @PutMapping("/{productId}")
    public ProductResponseDTO updateProductById(@PathVariable UUID productId,@RequestBody ProductRequestDTO productRequestDTO){
        return productService.updateProduct(productId,productRequestDTO);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable UUID productId){
        productService.deleteProduct(productId);
    }
}
