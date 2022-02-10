package org.example;

import org.example.config.SpringConfig;
import org.example.model.Customer;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.Scanner;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;


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
    public static void main(String[] args)
    {
        try {
            App app = new App();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Customer name: ");
            String custName = scanner.next();
            System.out.print("Enter Customer email: ");
            String customerMail = scanner.next();
            Customer customer=customerService.createCustomer(new Customer(new Random().nextInt(1000),custName,customerMail));
            System.out.println("Created a new customer... " + customer);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}