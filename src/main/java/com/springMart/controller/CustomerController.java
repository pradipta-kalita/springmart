package com.springMart.controller;

import com.springMart.dto.customer.CustomerRequestDTO;
import com.springMart.dto.customer.CustomerResponseDTO;
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
    public CustomerResponseDTO createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.createCustomer(customerRequestDTO);
    }

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public CustomerResponseDTO getCustomerById(@PathVariable UUID customerId){
        return customerService.getCustomerById(customerId);
    }

    @PutMapping("/{customerId}")
    public CustomerResponseDTO updateCustomerById(@PathVariable UUID customerId,@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.updateCustomerById(customerId,customerRequestDTO);
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
    public CustomerResponseDTO getCustomerByEmail(@RequestBody String email){
        return customerService.getCustomerByEmail(email);
    }

}
