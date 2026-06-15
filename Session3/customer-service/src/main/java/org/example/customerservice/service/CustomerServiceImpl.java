package org.example.customerservice.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import service.user_service.dto.Reponse.CustomerResponseDTO;
import service.user_service.dto.Request.CustomerRequestDTO;
import service.user_service.dto.Request.LoginRequestDTO;
import service.user_service.entity.Customer;
import service.user_service.exception.ResourceNotFoundException;
import service.user_service.repository.CustomerRepository;
import service.user_service.service.impl.CustomerService;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final  CustomerRepository repository;

    private final  PasswordEncoder passwordEncoder;

    @Override
    public CustomerResponseDTO register(CustomerRequestDTO dto) {

        Customer customer = new Customer();

        customer.setFullName(dto.getFullName());
        customer.setEmail(dto.getEmail());

        customer.setPassword(passwordEncoder.encode(dto.getPassword()));

        repository.save(customer);

        return mapToResponse(customer);
    }

    @Override
    public CustomerResponseDTO getCustomer(Long id) {

        Customer customer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));

        return mapToResponse(customer);
    }

    @Override
    public CustomerResponseDTO login(LoginRequestDTO dto) {

        Customer customer = repository.findByEmail(
                        dto.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "email or password incorrect"));

        boolean check = passwordEncoder.matches(
                dto.getPassword(),
                customer.getPassword());

        if (!check) {
            throw new RuntimeException(
                    "email or password incorrect");
        }

        return mapToResponse(customer);
    }

    private CustomerResponseDTO mapToResponse(Customer customer) {

        CustomerResponseDTO dto = new CustomerResponseDTO();

        dto.setId(customer.getId());
        dto.setFullName(customer.getFullName());
        dto.setEmail(customer.getEmail());

        return dto;
    }
}
