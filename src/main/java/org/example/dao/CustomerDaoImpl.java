package org.example.dao;

import org.example.config.SpringConfig;
import org.example.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;


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
}
