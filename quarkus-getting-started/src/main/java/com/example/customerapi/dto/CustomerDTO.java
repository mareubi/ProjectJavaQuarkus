package com.example.customerapi.dto;

import jakarta.validation.constraints.*;

public class CustomerDTO {
    @NotBlank public String firstName;
    public String middleName;
    @NotBlank public String lastName;
    public String secondLastName;
    @Email @NotBlank public String email;
    @NotBlank public String address;
    @NotBlank public String phone;
    @NotBlank public String country;
}