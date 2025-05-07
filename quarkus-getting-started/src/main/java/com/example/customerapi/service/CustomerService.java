package com.example.customerapi.service;

import com.example.customerapi.client.CountryClient;
import com.example.customerapi.dto.CustomerDTO;
import com.example.customerapi.exception.NotFoundException;
import com.example.customerapi.model.Customer;
import com.example.customerapi.repository.CustomerRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository repository;

    @Inject
    CountryClient countryClient;

    @Transactional
    public Customer createCustomer(CustomerDTO dto) {
        Customer customer = new Customer(dto);
        customer.nationality = countryClient.getNationality(dto.country);
        repository.persist(customer);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return repository.listAll();
    }

    public Customer getCustomerById(Long id) {
        return repository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Cliente no encontrado"));
    }

    public List<Customer> getCustomersByCountry(String code) {
        return repository.findByCountry(code);
    }

    @Transactional
    public Customer updateCustomer(Long id, CustomerDTO dto) {
        Customer customer = getCustomerById(id);
        customer.email = dto.email;
        customer.address = dto.address;
        customer.phone = dto.phone;
        customer.country = dto.country;
        customer.nationality = countryClient.getNationality(dto.country);
        return customer;
    }

    @Transactional
    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        repository.delete(customer);
    }
}