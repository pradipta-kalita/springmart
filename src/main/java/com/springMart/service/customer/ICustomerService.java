package com.springMart.service.customer;

import com.springMart.model.Customer;

import java.util.List;
import java.util.UUID;

public interface ICustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(UUID customerId);
    Customer updateCustomerById(UUID customerId, Customer customer);
    void deleteCustomer(UUID customerId);

    List<Customer> getAllCustomers();
    Customer findByEmail(String email);
}
