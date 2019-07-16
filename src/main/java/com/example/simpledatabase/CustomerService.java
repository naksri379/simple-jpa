package com.example.simpledatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer getData(){
        List<Customer> optionalCustomer = customerRepository.findByLastName("mylastname");
        return optionalCustomer.get(0);
    }

    public void setData(){
        // LocalDateTime myLocalDateTime = LocalDateTime.of(2015, Month.JULY, 29, 1, 1, 1);
        Customer customer = new Customer("myfristname", "mylastname", LocalDateTime.now());
        System.out.println("Create Date: " + customer.getMyDate());
        customerRepository.save(customer);
    }
}
