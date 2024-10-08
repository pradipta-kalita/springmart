package com.springMart.service.product;


import com.springMart.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    Product createProduct(Product product);
    Product getProductById(UUID id);
    List<Product> getAllProducts();
    Product updateProduct(UUID id, Product product);
    void deleteProduct(UUID id);
    Product addImageToProduct(UUID productId, MultipartFile file);
    Product removeImageFromProduct(UUID productId, UUID imageId);
}
