package org.example.dao;

import org.example.config.SpringConfig;
import org.example.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDaoImpl implements CustomerDao{
    @Override
    public Customer createCustomer(Customer customer) throws SQLException {

        SessionFactory sessionFactory = null;
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        sessionFactory = applicationContext.getBean("sessionFactory", SessionFactory.class);
        Session session = sessionFactory.openSession();


            session.getTransaction().begin();
            session.save(customer);
            session.getTransaction().commit();

        return customer;
    }

    @Override
    public Customer displayCustomer(Customer customer) throws SQLException {

        SessionFactory sessionFactory = null;
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        sessionFactory = applicationContext.getBean("sessionFactory", SessionFactory.class);

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        TypedQuery query= session.createQuery("FROM Customer C ");
        List<Customer> customers=query.getResultList();
        ArrayList list= new ArrayList<>();
        for(Customer c:customers){
            System.out.println(c);
            list.add(c);

        }session.getTransaction().commit();
        return customer;
    }
}
