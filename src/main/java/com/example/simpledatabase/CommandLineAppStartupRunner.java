package com.example.simpledatabase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Slf4j
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        //customerService.setData();
//        Customer customer = customerService.getData();
//        System.out.println(customer.getMyDate());
        //System.out.println("This is my date: " + optionalCustomer.get(0).getMyDate());

    }
}
