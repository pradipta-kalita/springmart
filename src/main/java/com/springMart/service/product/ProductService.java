package com.springMart.service.product;

import com.springMart.dto.product.ProductRequestDTO;
import com.springMart.dto.product.ProductResponseDTO;
import com.springMart.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public class ProductService implements IProductService {

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(UUID id) {
        return null;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO productRequestDTO) {
        return null;
    }


    @Override
    public void deleteProduct(UUID id) {

    }

    @Override
    public ProductResponseDTO addImageToProduct(UUID productId, MultipartFile file) {
        return null;
    }

    @Override
    public ProductResponseDTO removeImageFromProduct(UUID productId, UUID imageId) {
        return null;
    }
}
