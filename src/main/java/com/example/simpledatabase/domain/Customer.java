package com.example.simpledatabase.domain;

import com.example.simpledatabase.TimezonedLocalDateTimeConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "mydate")
    @Convert(converter = TimezonedLocalDateTimeConverter.class)
    private LocalDateTime myDate;

    protected Customer() {
    }


    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public Customer(String firstName, String lastName, LocalDateTime myDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.myDate = myDate;
    }


}