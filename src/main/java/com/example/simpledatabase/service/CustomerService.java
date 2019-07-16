package com.example.simpledatabase.service;

import com.example.simpledatabase.domain.Customer;
import com.example.simpledatabase.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public String getAllData() {
        Iterable<Customer> optionalCustomer = customerRepository.findAll();
        return optionalCustomer.toString();
    }

    public String getByLastNameData(String lastName) {
        List<Customer> optionalCustomer = customerRepository.findByLastName(lastName);
        return optionalCustomer.toString();
    }

    public void setData() {
        // LocalDateTime myLocalDateTime = LocalDateTime.of(2015, Month.JULY, 29, 1, 1, 1);
        Customer customer = new Customer("myfristname", "mylastname", LocalDateTime.now());
        System.out.println("Create Date: " + customer.getMyDate());
        customerRepository.save(customer);
    }
}
