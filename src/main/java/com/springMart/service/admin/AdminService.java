package com.springMart.service.admin;

import com.springMart.model.Category;
import com.springMart.model.Product;
import com.springMart.model.admin.Admin;
import com.springMart.repository.AdminRepository;
import com.springMart.repository.CategoryRepository;
import com.springMart.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AdminService implements IAdminService{

    private final AdminRepository adminRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public AdminService(AdminRepository adminRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.adminRepository = adminRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
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
    public Product createProduct(Product product) {
        return productRepository.save(product);
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
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}
