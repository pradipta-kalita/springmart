package com.springMart.service.customer;

import com.springMart.model.Customer;
import com.springMart.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerService implements ICustomerService{

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return null;
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return null;
    }

    @Override
    public Customer updateCustomerById(UUID customerId, Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomerById(UUID customerId) {

    }

    @Override
    public void deleteCustomerByEmail(String email) {

    }

    @Override
    public List<Customer> getAllCustomers() {
        return List.of();
    }

    @Override
    public Customer findByEmail(String email) {
        return null;
    }
}
