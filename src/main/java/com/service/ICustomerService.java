package com.service;

import com.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
    void remove(Long id);



}
