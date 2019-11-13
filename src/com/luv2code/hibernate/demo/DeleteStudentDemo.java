package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {

           // int studentId = 2;
            session.beginTransaction();

            //System.out.println("\nGetting the student with id: " + studentId);
            //Student myStudent = session.get(Student.class, studentId);

            session.createQuery("delete from Student where id=2").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
