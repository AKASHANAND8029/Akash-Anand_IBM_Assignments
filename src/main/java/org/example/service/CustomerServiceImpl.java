package org.example.service;

import org.example.Customer;
import org.example.repo.CustomerRepository;
import org.example.repo.CustomerRepositoryImpl;

import java.sql.SQLException;
import java.util.Currency;

public class CustomerServiceImpl implements CustomerService{
private CustomerRepository customerRepository;
public CustomerServiceImpl(){
    customerRepository=new CustomerRepositoryImpl();

}

    @Override
    public Customer createCustomer(Customer customer) throws SQLException {
        return customerRepository.createCustomer(customer);

    }

    @Override
    public Customer viewAccount(String username, int password) throws SQLException {
        return customerRepository.viewAccount(username,password);
    }

    @Override
    public Customer customerLogin(String username, int password) throws SQLException {
     Customer customer=null;
     customer=customerRepository.customerLogin(username,password);
     if(customer==null){
         throw new NullPointerException("Incorrect username or password");

     }
     return customer;
    }

    @Override
    public Customer findCustomerByAccount(Integer accountNumber) throws SQLException {
     Customer customer=null;
     customer=customerRepository.findCustomerByAccount(accountNumber);
        if (customer==null)
        {
            throw new NullPointerException("no such element found");
        }
        return customer;


    }

    @Override
    public Customer deleteCustomer(String username, int password) throws SQLException {
        return customerRepository.deleteCustomer(username,password);
    }

    @Override
    public Customer updateCustomerPassword(Integer accountNumber) throws SQLException {
        return customerRepository.updateCustomerPassword(accountNumber);
    }

    @Override
    public Customer amountDeposit(Integer accountNumber) throws SQLException {
        return customerRepository.amountDeposit(accountNumber);
    }

    @Override
    public Customer amountWithdraw(Integer accountNumber) throws SQLException {
        return customerRepository.amountWithdraw(accountNumber);
    }
}
