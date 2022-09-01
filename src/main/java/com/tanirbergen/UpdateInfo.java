package com.tanirbergen;

import com.tanirbergen.Model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateInfo {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 2);
            person.setName("Oleg");

            Person person1 = session.get(Person.class, 5);
            person1.setAge(23);

            Person person2 = session.get(Person.class, 1);
            person2.setAge(54);
            person2.setName("Aibek");

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
