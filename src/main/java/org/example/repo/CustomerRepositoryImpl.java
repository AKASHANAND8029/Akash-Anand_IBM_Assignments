package org.example.repo;

import org.example.factory.MyConnection;
import org.example.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerRepositoryImpl implements CustomerRepository{
    private MyConnection myConnection;
    private ResultSet resultSet;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private Connection connection;
    Scanner scanner=new Scanner(System.in);

    public CustomerRepositoryImpl() {
        myConnection=MyConnection.getObject();
        try{
            connection= myConnection.getMyConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Customer viewAccount(String username, int password) throws SQLException {
        preparedStatement=connection.prepareStatement("select * from bankcustomer where user=? or pass=?");
        List<Customer> list=new ArrayList<>();
        preparedStatement.setString(1,username);
        preparedStatement.setInt(2,password);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next())
        {
            list.add(new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5)));
        }
        if (list.isEmpty())
        {
            return null;
        }
        else
        {
            return list.get(0);
        }
    }

    @Override
    public Customer customerLogin(String username, int password) throws SQLException {
        preparedStatement=connection.prepareStatement("select * from bankcustomer where user=? or pass=?");
   List<Customer> list=new ArrayList<>();
   preparedStatement.setString(1,username);
   preparedStatement.setInt(2,password);
   resultSet=preparedStatement.executeQuery();
   while (resultSet.next())
   {
       list.add(new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5)));
       }
        if (list.isEmpty())
        {
            return null;
        }
        else
        {
            return list.get(0);
        }
    }

    @Override
    public Customer createCustomer(Customer customer) throws SQLException {
        preparedStatement=connection.prepareStatement("insert into bankcustomer(acc_num,cname,balance,user,pass) values(?,?,?,?,?)");
        preparedStatement.setInt(1,customer.getAccountNumber());
        preparedStatement.setString(2,customer.getCustomerName());
        preparedStatement.setInt(3,customer.getBalance());
        preparedStatement.setString(4,customer.getUsername());
        preparedStatement.setInt(5,customer.getPassword());
        int result=preparedStatement.executeUpdate();
        System.out.println(result+" Congratulations you are now a part of our family!");
        return customer;

    }

    @Override
    public Customer findCustomerByAccount(Integer accountNumber) throws SQLException {
        preparedStatement= connection.prepareStatement("select * from bankcustomer where acc_num=?");
        List<Customer> list=new ArrayList<>();
        preparedStatement.setInt(1,accountNumber);
        resultSet= preparedStatement.executeQuery();
        while (resultSet.next()) {
            list.add(new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5)));

        }

        if (list.isEmpty())
        {
            return null;
        }
        else
        {
            return list.get(0);
        }



            }

    @Override
    public Customer updateCustomerPassword(Integer accountNumber) throws SQLException {
       Customer customer=findCustomerByAccount(accountNumber);
       if(customer==null)
       {
         System.out.println("Customer with account number"+accountNumber+" not found");

       }
       else {

           System.out.println("Welcome to your account: "+customer);
           System.out.println("Enter New Password");
           int newPassword=scanner.nextInt();
           preparedStatement= connection.prepareStatement("update bankcustomer set pass=? where acc_num=?");
           preparedStatement.setInt(1,newPassword);
           preparedStatement.setInt(2,accountNumber);
           preparedStatement.executeUpdate();
           customer.setPassword(newPassword);
           customer.setAccountNumber(accountNumber);


       }



        return customer;
    }

    @Override
    public Customer amountDeposit(Integer accountNumber) throws SQLException {

        Customer customer=findCustomerByAccount(accountNumber);
        if (customer==null)
        {
            System.out.println("customer with the account "+accountNumber+" not found");
        }
        else{
        System.out.print("Enter the amount you want to deposit: ");
        int depositAmount= scanner.nextInt();

        preparedStatement= connection.prepareStatement("update bankcustomer set balance=balance+? where acc_num=? ");

        preparedStatement.setInt(1,depositAmount);
        preparedStatement.setInt(2,accountNumber);
        preparedStatement.executeUpdate();

      customer.setBalance(depositAmount);
      customer.setAccountNumber(accountNumber);

        }


        return customer;
    }

    @Override
    public Customer amountWithdraw(Integer accountNumber) throws SQLException {
        Customer customer=findCustomerByAccount(accountNumber);
        if (customer==null)
        {
            System.out.println("customer with the account "+accountNumber+" not found");
        }
        else{
            System.out.print("Enter the amount you want to Withdraw: ");
            int withdrawAmount= scanner.nextInt();

            preparedStatement= connection.prepareStatement("update bankcustomer set balance=balance-? where acc_num=? ");

            preparedStatement.setInt(1,withdrawAmount);
            preparedStatement.setInt(2,accountNumber);
            preparedStatement.executeUpdate();

            customer.setBalance(withdrawAmount);
            customer.setAccountNumber(accountNumber);

        }
        return customer;
    }

    @Override
    public Customer deleteCustomer(String username, int password) throws SQLException {
        preparedStatement=connection.prepareStatement("delete from bankcustomer where user=? and pass=?");
        preparedStatement.setString(1,username);
        preparedStatement.setInt(2,password);

        int result= preparedStatement.executeUpdate();
        if (result==0)
        {
            System.out.println("no such record.");
        }
        else {
            System.out.println("Sorry to see you go :(\n Thanks for being our valuable member!");
        }return null;
    }
}
