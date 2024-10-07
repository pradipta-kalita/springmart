package com.springMart.service.customer;

import com.springMart.model.Customer;

import java.util.List;
import java.util.UUID;

public class CustomerService implements ICustomerService{
    @Override
    public Customer createCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return null;
    }

    @Override
    public Customer updateCustomerById(UUID customerId, Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(UUID customerId) {

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
