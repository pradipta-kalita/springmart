package com.springMart.controller;

import com.springMart.model.Customer;
import com.springMart.service.customer.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable UUID customerId){
        return customerService.getCustomerById(customerId);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomerById(@PathVariable UUID customerId,@RequestBody Customer customer){
        return customerService.updateCustomerById(customerId,customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomerById(@PathVariable UUID customerId){
        customerService.deleteCustomerById(customerId);
    }

    @DeleteMapping
    public void deleteCustomerByEmail(@RequestBody String email){
        customerService.deleteCustomerByEmail(email);
    }

    @GetMapping("/email")
    public Customer getCustomerByEmail(@RequestBody String email){
        return customerService.getCustomerByEmail(email);
    }

}
