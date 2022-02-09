package org.example.repo;

import org.example.Customer;

import java.sql.SQLException;
import java.util.Currency;

public interface CustomerRepository {
 public Customer customerLogin(String username, int password) throws SQLException;
 public Customer updateCustomerPassword(Integer accountNumber) throws  SQLException;
 public Customer amountDeposit(Integer accountNumber) throws SQLException;
 public Customer amountWithdraw(Integer accountNumber) throws SQLException;
 public Customer viewAccount(String username, int password) throws SQLException;
public Customer createCustomer(Customer customer) throws SQLException;
 public Customer findCustomerByAccount(Integer accountNumber) throws SQLException;
 public Customer deleteCustomer(String username, int password) throws SQLException;
}
