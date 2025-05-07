package com.example.customerapi.service;

import com.example.customerapi.client.CountryClient;
import com.example.customerapi.dto.CustomerDTO;
import com.example.customerapi.model.Customer;
import com.example.customerapi.repository.CustomerRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@QuarkusTest
public class CustomerServiceTest {

    CustomerService customerService;
    CustomerRepository repository;
    CountryClient countryClient;

    @BeforeEach
    void setup() {
        repository = mock(CustomerRepository.class);
        countryClient = mock(CountryClient.class);
        customerService = new CustomerService();
        customerService.repository = repository;
        customerService.countryClient = countryClient;
    }

    @Test
    void testCreateCustomer() {
        CustomerDTO dto = new CustomerDTO();
        dto.firstName = "Ana";
        dto.lastName = "Pérez";
        dto.email = "ana@mail.com";
        dto.address = "Calle 1";
        dto.phone = "123456";
        dto.country = "DO";

        when(countryClient.getNationality("DO")).thenReturn("Dominican");

        Customer result = customerService.createCustomer(dto);

        assertEquals("Ana", result.firstName);
        assertEquals("Dominican", result.nationality);
    }

    @Test
    void testGetCustomerById() {
        Customer c = new Customer();
        c.id = 1L;
        c.firstName = "Luis";
        when(repository.findByIdOptional(1L)).thenReturn(Optional.of(c));

        Customer result = customerService.getCustomerById(1L);
        assertEquals("Luis", result.firstName);
    }

    @Test
    void testDeleteCustomer() {
        Customer c = new Customer();
        c.id = 1L;
        when(repository.findByIdOptional(1L)).thenReturn(Optional.of(c));

        customerService.deleteCustomer(1L);

        verify(repository).delete(c);
    }

    @Test
    void testUpdateCustomer() {
        Customer c = new Customer();
        c.id = 1L;
        when(repository.findByIdOptional(1L)).thenReturn(Optional.of(c));
        when(countryClient.getNationality("US")).thenReturn("American");

        CustomerDTO dto = new CustomerDTO();
        dto.email = "new@mail.com";
        dto.address = "New address";
        dto.phone = "999999";
        dto.country = "US";

        Customer updated = customerService.updateCustomer(1L, dto);

        assertEquals("new@mail.com", updated.email);
        assertEquals("American", updated.nationality);
    }
}