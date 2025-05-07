package com.example.customerapi.repository;

import com.example.customerapi.model.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public List<Customer> findByCountry(String code) {
        return list("country", code);
    }
}
