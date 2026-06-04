package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping("/customer")
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.postCustomer(customer);

    }

    @RequestMapping("/customers/search")
    public List<Customer> searchCustomer(@RequestParam String name){
        return  customerService.searchByName(name);
    }


    @RequestMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null)
            return ResponseEntity.notFound().build();
            return ResponseEntity.ok(customer);

    }


    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer == null)
            return ResponseEntity.notFound().build();
            existingCustomer.setName(customer.getName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhoneNo(customer.getPhoneNo());
        existingCustomer.setProfile(customer.getProfile());


            Customer updatedCustomer = customerService.updateCustomer(existingCustomer);
            return ResponseEntity.ok(updatedCustomer);




    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {

        Customer existingCustomer = customerService.getCustomerById(id);

        if (existingCustomer == null) {
            return ResponseEntity.notFound().build();
        }

        customerService.deleteCustomer(id);

        return ResponseEntity.ok().build();
    }


}
