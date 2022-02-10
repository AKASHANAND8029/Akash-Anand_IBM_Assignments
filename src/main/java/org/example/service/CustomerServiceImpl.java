package org.example.service;

import org.example.model.Customer;
import org.example.dao.CustomerDao;
import org.example.dao.CustomerDaoImpl;

import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService{
    private CustomerDao customerDao;
    public CustomerServiceImpl(){
        customerDao=new CustomerDaoImpl();
    }

    @Override
    public Customer createCustomer(Customer customer) throws SQLException {
        return customerDao.createCustomer(customer);
    }

    @Override
    public Customer displayCustomer(Customer customer) throws SQLException {
        return customerDao.displayCustomer(customer);
    }
}
