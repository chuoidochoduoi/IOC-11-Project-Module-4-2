package org.example.customerservice.service.impl;

import service.user_service.dto.Reponse.CustomerResponseDTO;
import service.user_service.dto.Request.CustomerRequestDTO;
import service.user_service.dto.Request.LoginRequestDTO;

public interface CustomerService {

    CustomerResponseDTO register(CustomerRequestDTO dto);

    CustomerResponseDTO getCustomer(Long id);

    CustomerResponseDTO login(LoginRequestDTO dto);
}