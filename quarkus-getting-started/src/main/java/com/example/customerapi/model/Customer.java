package com.example.customerapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank 
    public String firstName;

    public String middleName;

    @NotBlank 
    public String lastName;

    public String secondLastName;
    
    @Email 
    @NotBlank 
    public String email;

    @NotBlank 
    public String address;

    @NotBlank 
    public String phone;

    @NotBlank 
    public String country; 
    
    public String nationality;

    public Customer() {}

    public Customer(com.example.customerapi.dto.CustomerDTO dto) {
        this.firstName = dto.firstName;
        this.middleName = dto.middleName;
        this.lastName = dto.lastName;
        this.secondLastName = dto.secondLastName;
        this.email = dto.email;
        this.address = dto.address;
        this.phone = dto.phone;
        this.country = dto.country;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return this.secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}

