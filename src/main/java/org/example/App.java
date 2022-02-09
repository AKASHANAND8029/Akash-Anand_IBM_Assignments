package org.example;

import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.*;
import java.util.Currency;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App
    {
        private static CustomerService customerService;
        static {
            customerService=new CustomerServiceImpl();
        }
    public static void main( String[] args )
    {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("_||_ Welcome to India bank _||_");

        int choice=0;


          System.out.println("1. Create Your account.");
          System.out.println("2. Login To Your account.");
          System.out.println("3. Update Your Password.");
          System.out.println("4. Deposit Amount.");
          System.out.println("5. Withdraw Amount.");
          System.out.println("6. View Your Account.");
          System.out.println("7. Delete Your account");
          System.out.print("Please enter your choice: ");


do{
    try {
        choice = Integer.parseInt(bufferedReader.readLine());

        switch (choice) {
            case 1:
                         //CREATE CUSTOMER
                    System.out.print("Please Enter your name: ");
                    String name = bufferedReader.readLine();
                    System.out.print("Create your username: ");
                    String username = bufferedReader.readLine();
                    System.out.print("Create your password: ");
                    System.out.print("Amount you want to deposit: ");
                    int amount = Integer.parseInt(bufferedReader.readLine());
                    int password = Integer.parseInt(bufferedReader.readLine());
                    Customer customer = customerService.createCustomer(new Customer(new Random().nextInt(10000), name, amount, username, password));

                    System.out.println(customer);
                    break;


            case 2:
                           //LOGIN CUSTOMER
                    System.out.print("Enter username: ");
                    String u_name = bufferedReader.readLine();
                    System.out.print("Enter your password: ");
                    int pass = bufferedReader.read();
                    Customer customer1 = customerService.customerLogin(u_name, pass);
                    System.out.println("You have logged in successfully");
                    System.out.println(customer1);
                    break;

            case 3:

                    //UPDATE PASSWORD
                    System.out.print("Enter Account Number: ");
                    int accountNumber = Integer.parseInt(bufferedReader.readLine());
                    Customer customer2 = customerService.updateCustomerPassword(accountNumber);
                    System.out.print("Updated your password: ");
                    break;

            case 4:

                    //DEPOSIT

                    System.out.print("Enter Account Number: ");
                    int accountNumber1 = Integer.parseInt(bufferedReader.readLine());

                    Customer customer3 = customerService.amountDeposit(accountNumber1);
                    System.out.print("Amount has been successfully deposited in your account.");
                    break;

            case 5:

                    //WITHDRAW
                    System.out.print("Enter Account Number: ");
                    int accountNumber2 = Integer.parseInt(bufferedReader.readLine());

                    Customer customer4 = customerService.amountWithdraw(accountNumber2);
                    System.out.print("Amount Withdrawn has been withdrawn from your account");
                    break;

            case 6:


                    //VIEW ACCOUNT
                    System.out.print("Enter username: ");
                    String u_name1 = bufferedReader.readLine();
                    System.out.print("Enter password: ");
                    int pass1 = bufferedReader.read();
                    Customer customer5 = customerService.customerLogin(u_name1, pass1);
                    System.out.println(customer5);
                    break;

            case 7:

                    //DELETE ACCOUNT
                    System.out.print("Enter username: ");
                    String userName = bufferedReader.readLine();
                    System.out.print("Enter password: ");
                    int password1 = Integer.parseInt(bufferedReader.readLine());
                    customerService.deleteCustomer(userName, password1);
                    break;
            default:
                System.out.println("Thank you for using our service:)");
                break;




            //FIND BY ACCOUNT NUMBER
            /*System.out.print("Please enter Account Number: ");
            int acc=Integer.parseInt(bufferedReader.readLine());
            Customer customer=customerService.findCustomerByAccount(acc);
            System.out.println(customer);*/

        }
    } catch (IOException | SQLException | NullPointerException e) {
        System.out.println(e.getMessage());
    }


}while (choice!=0);
    }
}
