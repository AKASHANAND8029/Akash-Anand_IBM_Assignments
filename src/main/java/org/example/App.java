package org.example;

import org.example.config.SpringConfig;
import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        try {
            //CREATING STUDENTS AND PHOTOS

            Scanner scanner=new Scanner(System.in);
            AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
            SessionFactory sessionFactory=applicationContext.getBean("sessionFactory",SessionFactory.class);
            Session session= sessionFactory.openSession();
            System.out.print("Enter First Name: ");
            String firstName = scanner.next();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.next();
            System.out.print("Enter Email: ");
            String email=scanner.next();
            Student tempStudent = new Student(new Random().nextInt(1000),firstName,lastName,email);
            Set<String> theImages = tempStudent.getImages();
            System.out.print("Enter photo: ");
            String photo=scanner.next();
            theImages.add(photo+".jpg");
            //start a transaction
            session.beginTransaction();
            //save the object
            System.out.println("Saving the student and images..");
            session.persist(tempStudent);
            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!");

            //DISPLAY ALL STUDENT
            /*SessionFactory sessionFactory=null;
            AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
             sessionFactory=applicationContext.getBean("sessionFactory",SessionFactory.class);
            Session session= sessionFactory.openSession();
            session.getTransaction().begin();
            TypedQuery query= session.createQuery("FROM Student S ");
            List<Student> studentList=query.getResultList();
            ArrayList list= new ArrayList<>();
            for(Student s:studentList){
                System.out.println(s);
                list.add(s);
            }session.getTransaction().commit();*/
                    }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}