package org.example.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.user_service.dto.Reponse.CustomerResponseDTO;
import service.user_service.dto.Request.CustomerRequestDTO;
import service.user_service.dto.Request.LoginRequestDTO;
import service.user_service.service.impl.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/register")
    public CustomerResponseDTO register(@RequestBody CustomerRequestDTO dto) {

        return service.register(dto);
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable Long id) {

        return service.getCustomer(id);
    }

    @PutMapping("/login")
    public CustomerResponseDTO login(@RequestBody LoginRequestDTO dto) {

        return service.login(dto);
    }
}