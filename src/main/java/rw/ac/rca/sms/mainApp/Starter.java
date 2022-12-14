package rw.ac.rca.sms.mainApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import rw.ac.rca.sms.orm.Address;
import rw.ac.rca.sms.orm.Course;
import rw.ac.rca.sms.orm.Instructor;
import rw.ac.rca.sms.orm.Student;

import java.sql.SQLException;
import java.util.Date;
@SuppressWarnings("deprecated")
public class Starter {
    public static void main(String[] args){
        Address address1 = new Address("Nyabihu" , "KN4 St13");
        Address address2 = new Address("Kigali" , "KG3 St18");

        Student student1 = new Student();
        Student student2 = new Student();
        Course course1 = new Course("Biology" , 12 , 120);
        Course course2 = new Course("Chemistry" , 10 , 100);
        Instructor instructor1 = new Instructor();
        Instructor instructor2 = new Instructor();

//        setting the address id manuallly
//        address1.setAddress_id(1);
//        address2.setAddress_id(2);

        //the first instructor
        instructor1.setAddress(address1);
        instructor1.setDob(new Date(1980 , 06 , 16));
        instructor1.setPhoneNumber("0788271071");
        instructor1.setGender('F');
        instructor1.setName("Mia Anderson");

        //the second instructor
        instructor2.setAddress(address2);
        instructor2.setDob(new Date(1950 , 05 , 16));
        instructor2.setPhoneNumber("0778099764");
        instructor2.setGender('F');
        instructor2.setName("Ingabire Divine");

        //the first student
        student1.setAddress(address1);
        student1.setDob(new Date(2005 , 05 , 16));
        student1.setName("Lauren James");
        student1.setPhoneNumber("0798980264");

        //the second students
        student2.setAddress(address2);
        student2.setDob(new Date(2007 , 05 , 16));
        student2.setName("Aline Frost");
        student2.setPhoneNumber("0798985664");

        course1.setStudent(student1);
        course1.setStudent(student2);
        System.out.println("Finished closing the factory and session..........");

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor1);

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        System.out.println("config file loaded ..............");

        try {
            @SuppressWarnings("deprecation")
            SessionFactory factory = config.buildSessionFactory();
            Session session = factory.openSession();

            Transaction transaction = session.beginTransaction();
            System.out.println("Beginning transaction...............");

            session.saveOrUpdate(address1);
            session.saveOrUpdate(address2);

            session.saveOrUpdate(instructor1);
            session.saveOrUpdate(instructor2);

            session.saveOrUpdate(student1);
            session.saveOrUpdate(student2);

            session.saveOrUpdate(course1);
            session.saveOrUpdate(course2);

            transaction.commit();
            System.out.println("Before closing the session..........");

            session.close();
            factory.close();

            System.out.println("Finished closing the factory and session..........");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}