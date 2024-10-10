package com.springMart.service.admin;

import com.springMart.dto.ProductRequestDTO;
import com.springMart.model.Category;
import com.springMart.model.Image;
import com.springMart.model.Product;
import com.springMart.model.admin.Admin;
import com.springMart.repository.AdminRepository;
import com.springMart.repository.CategoryRepository;
import com.springMart.repository.ImageRepository;
import com.springMart.repository.ProductRepository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AdminService implements IAdminService{

    private final AdminRepository adminRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    @Getter
    @Value("${upload.dir}")
    private String uploadDir;

    public AdminService(AdminRepository adminRepository, CategoryRepository categoryRepository, ProductRepository productRepository, ImageRepository imageRepository) {
        this.adminRepository = adminRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public void deleteCategory(UUID categoryId) {
        Optional<Category> optionalCategory= categoryRepository.findById(categoryId);
        if(optionalCategory.isPresent()){
            categoryRepository.deleteById(optionalCategory.get().getId());
        }else{
            throw new RuntimeException("Category doesn't exist.");
        }
    }

    @Override
    public Category updateCategory(UUID categoryId, Category category) {
        Optional<Category> optionalCategory= categoryRepository.findById(categoryId);
        if(optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setName(category.getName());
            existingCategory.setDescription(category.getDescription());
            return categoryRepository.save(existingCategory);
        }else{
            throw new RuntimeException("Category not found.");
        }
    }

    @Override
    public Product createProduct(ProductRequestDTO product) {
        System.out.println("It entered createProduct() method");
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setInventory(product.getInventory());
        Optional<Category> optionalCategory = categoryRepository.findById(product.getCategoryId());
        if(optionalCategory.isPresent()){
            System.out.println("Category id :" + (optionalCategory.get().getId()).toString());
            newProduct.setCategory(optionalCategory.get());
        }else{
            throw new RuntimeException("Category not found.");
        }
        Product savedProduct = productRepository.saveAndFlush(newProduct);
        MultipartFile[] images = product.getImages();
        if (images != null && images.length > 0) {
            for (MultipartFile image : images) {
                // Check if the content type is an image (you can allow specific types)
                String contentType = image.getContentType();
                if (contentType == null || !contentType.equals("image/jpeg")) {
                    throw new RuntimeException("Only JPG files are allowed.");
                }

                // Ensure the upload directory exists
                File dir = new File(getUploadDir());
                if (!dir.exists()) {
                    boolean dirsCreated = dir.mkdirs();
                    if (!dirsCreated) {
                        throw new RuntimeException("Failed to create directory for uploads");
                    }
                }

                // Generate a unique filename and save the file
                String filename = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
                try {
                    File serverFile = new File(dir, filename);
                    image.transferTo(serverFile);

                    // Create Image entity and save it
                    Image newImage = new Image();
                    newImage.setUrl(Paths.get("uploads/images", filename).toString()); // Store relative URL or path
                    newImage.setProduct(savedProduct);
                    imageRepository.saveAndFlush(newImage);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to store image", e);
                }
            }
        }

        return productRepository.findById(newProduct.getId()).orElseThrow(()-> new RuntimeException("Product not found."));
    }

    @Override
    public Product updateProduct(UUID productId, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()){
            Product existingProduct =  optionalProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setInventory(product.getInventory());
            if(product.getCategory()!=null && product.getCategory().getId()!=null){
                Optional<Category> optionalCategory = categoryRepository.findById(product.getCategory().getId());
                if(optionalCategory.isPresent()){
                    Category existingCategory = optionalCategory.get();
                    existingProduct.setCategory(existingCategory);
                }else{
                    throw new RuntimeException("Category not found.");
                }
            }
            return productRepository.save(existingProduct);
        }else{
            throw new RuntimeException("Product not found.");
        }
    }

    @Override
    public void deleteProduct(UUID productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()){
            productRepository.deleteById(optionalProduct.get().getId());
        }else{
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(UUID adminId) {
        Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
        if(optionalAdmin.isPresent()){
            adminRepository.deleteById(optionalAdmin.get().getId());
        }else{
            throw new RuntimeException("Admin does not exist.");
        }
    }


}
