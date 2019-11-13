package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            System.out.println("Saving the student....");
            List<Student> theStudents = session.createQuery("from Student").list();
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='Daffy'").list();
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
            displayStudents(theStudents);

            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception exc){
            exc.printStackTrace();
        } finally {
          factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents){
        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }

    }
}
