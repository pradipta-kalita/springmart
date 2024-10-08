package com.springMart.service.admin;

import com.springMart.model.Category;
import com.springMart.model.Product;
import com.springMart.model.admin.Admin;
import com.springMart.model.admin.AdminRole;
import com.springMart.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class AdminService implements IAdminService{

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void createCategory(Category category) {

    }

    @Override
    public void deleteCategory(UUID categoryId) {

    }

    @Override
    public void updateCategory(UUID categoryId, Category category) {

    }

    @Override
    public void createProduct(Product product) {

    }

    @Override
    public void updateProduct(UUID productId, Product product) {

    }

    @Override
    public void deleteProduct(UUID productId) {

    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}
