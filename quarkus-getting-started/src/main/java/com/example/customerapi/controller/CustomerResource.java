package com.example.customerapi.controller;

import com.example.customerapi.dto.CustomerDTO;
import com.example.customerapi.model.Customer;
import com.example.customerapi.service.CustomerService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @POST
    public Response createCustomer(@Valid CustomerDTO dto) {
        Customer customer = customerService.createCustomer(dto);
        return Response.status(Response.Status.CREATED).entity(customer).build();
    }

    @GET
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GET
    @Path("/{id}")
    public Customer getCustomerById(@PathParam("id") Long id) {
        return customerService.getCustomerById(id);
    }

    @GET
    @Path("/country/{code}")
    public List<Customer> getCustomersByCountry(@PathParam("code") String code) {
        return customerService.getCustomersByCountry(code);
    }

    @PUT
    @Path("/{id}")
    public Customer updateCustomer(@PathParam("id") Long id, @Valid CustomerDTO dto) {
        return customerService.updateCustomer(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") Long id) {
        customerService.deleteCustomer(id);
        return Response.noContent().build();
    }
}