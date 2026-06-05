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

    public void deleteCustomer(Long id){
         customerRepo.deleteById(id);
    }

    public List<Customer> searchByName(String name){
        return customerRepo.findByNameContainingIgnoreCase(name);
    }

    public Customer register(Customer customer){

        Customer existingCustomer =
                customerRepo.findByUsername(
                        customer.getUsername());

        if(existingCustomer != null){
            return null;
        }

        return customerRepo.save(customer);
    }

    public Customer login(
            String username,
            String password){

        return customerRepo
                .findByUsernameAndPassword(
                        username,
                        password);
    }
}
