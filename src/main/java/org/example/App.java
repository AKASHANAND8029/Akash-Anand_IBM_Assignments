package org.example;

import org.example.config.SpringConfig;
import org.example.model.Employee;
import org.example.model.EmployeeType;

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

            /*Scanner scanner=new Scanner(System.in);
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
            Map<String, String> theImages=tempStudent.getImages();
            //List<String> theImages=  tempStudent.getImages();
            //Set<String> theImages = tempStudent.getImages();
//            System.out.print("Enter file name: ");
//            String photoName=scanner.next();
//            System.out.print("Enter photo: ");
//            String photo=scanner.next();
            //MAP
            //theImages.put(photoName+".jpg",photo);
            theImages.put("photo1.jpg","Photo 1");
            theImages.put("photo2.jpg","Photo 2");
            theImages.put("photo3.jpg","Photo 3");
            //theImages.add(photo+".jpg");
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

            //Hibernate mapping list find by name and update email by id
            /*SessionFactory sessionFactory=null;
            AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
            sessionFactory=applicationContext.getBean("sessionFactory",SessionFactory.class);
            Session session= sessionFactory.openSession();
            session.getTransaction().begin();
            Scanner scanner=new Scanner(System.in);
            System.out.print("Enter student name: ");
            String studentName = scanner.next();
            TypedQuery query= session.createQuery("FROM Student S WHERE S.firstName=:sName ");
            query.setParameter("sName",studentName);
            List<Student> studentList=query.getResultList();
             // update email by id
            System.out.println("enter id");
            int id=scanner.nextInt();
            System.out.println("enter updated email");
            String email=scanner.next();
            Student student = session.load(Student.class,id);
            student.setEmail(email);
            session.update(student);
            session.getTransaction().commit();
            Iterator<Student> iterator= studentList.iterator();
            while (iterator.hasNext())
            {
                System.out.println(iterator.next());

            }*/
            AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
            SessionFactory sessionFactory=applicationContext.getBean("sessionFactory",SessionFactory.class);
            Session session= sessionFactory.openSession();
            session.getTransaction().begin();
            Employee employee=new Employee(new Random().nextInt(1000),UUID.randomUUID().toString(),"Marry Public",10000.0, EmployeeType.CONTRACT_EMPLOYEE);
            session.persist(employee);
            session.getTransaction().commit();
            System.out.println("saved...");
            System.out.println(employee);
            // update email by id
//            Scanner scanner=new Scanner(System.in);
//            System.out.println("enter unique id");
//            String  id=scanner.next();
//            System.out.println("enter updated salary");
//            double sal=scanner.nextInt();
//            Employee employee1=session.load(Employee.class,id);
//            employee1.setSalary(sal);
//            session.update(employee1);
//            System.out.println(employee1);
//
//            session.getTransaction().commit();



                    }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}