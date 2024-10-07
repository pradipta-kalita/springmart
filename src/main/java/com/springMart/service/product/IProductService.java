package com.springMart.service.product;

import com.springMart.dto.product.ProductRequestDTO;
import com.springMart.dto.product.ProductResponseDTO;
import com.springMart.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO getProductById(UUID id);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO updateProduct(UUID id, ProductRequestDTO productRequestDTO);
    void deleteProduct(UUID id);
    ProductResponseDTO addImageToProduct(UUID productId, MultipartFile file);
    ProductResponseDTO removeImageFromProduct(UUID productId, UUID imageId);
}
