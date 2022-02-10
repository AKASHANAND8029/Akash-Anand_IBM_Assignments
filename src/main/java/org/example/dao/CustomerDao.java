package org.example.dao;

import org.example.model.Customer;

import java.sql.SQLException;

public interface CustomerDao {

public Customer createCustomer(Customer customer) throws SQLException;
}
