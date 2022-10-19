package com.service.customer;

import com.model.Customer;
import com.repository.Customer.ICustomerRepository;
import com.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICustomerService {
    private static List<Customer> customers;
    private static long autoIncreaseId = 0;

    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }
}
