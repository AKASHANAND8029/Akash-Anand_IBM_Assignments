package org.example.service;

import org.example.model.Customer;

import java.sql.SQLException;

public interface CustomerService {
    public Customer createCustomer(Customer customer) throws SQLException;
}
