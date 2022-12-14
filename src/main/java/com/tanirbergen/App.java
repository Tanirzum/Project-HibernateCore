package com.tanirbergen;

import com.tanirbergen.Model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration configuration =
                new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();


            List<Person> people =
                    session.createQuery("FROM Person WHERE age > 20 ").getResultList();

            for (Person person : people) {
                System.out.println(person);
            }

            System.out.println();

            List<Person> personList = session.createQuery("FROM Person WHERE age > 20 AND  name LIKE 'A%' ").getResultList();

            for (Person person : personList) {
                System.out.println(person);
            }


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}
