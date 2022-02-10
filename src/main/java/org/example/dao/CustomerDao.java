package org.example.dao;

import org.example.model.Customer;

import java.sql.SQLException;

public interface CustomerDao {

public Customer createCustomer(Customer customer) throws SQLException;
public Customer displayCustomer(Customer customer) throws SQLException;
}
