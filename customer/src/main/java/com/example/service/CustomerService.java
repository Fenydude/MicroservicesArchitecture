package com.example.service;

import com.example.entity.Customer;
import com.example.entity.CustomerRegistration;
import com.example.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer registrationCustomer(CustomerRegistration customerRegistration){
        Customer customer = Customer.builder()
                .firstName(customerRegistration.firstName())
                .lastName(customerRegistration.lastName())
                .email(customerRegistration.email()).build();
        //todo: check if email valid
        //todo: check if email not taken
        customerRepository.save(customer);
        return customer;
    }
}
