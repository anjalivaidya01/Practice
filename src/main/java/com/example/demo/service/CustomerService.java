package com.example.demo.service;


import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    private final CustomerRepo customerRepo;


    public Customer postCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepo.findById(id).orElse(null);
    }

    public Customer updateCustomer(Customer customer){
        return customerRepo.save(customer);
    }
}
