package com.springMart.service.product;

import com.springMart.model.Product;
import com.springMart.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product getProductById(UUID id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(UUID id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(UUID id) {

    }

    @Override
    public Product addImageToProduct(UUID productId, MultipartFile file) {
        return null;
    }

    @Override
    public Product removeImageFromProduct(UUID productId, UUID imageId) {
        return null;
    }
}
