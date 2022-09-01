package com.tanirbergen;

import com.tanirbergen.Model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddingInfo {
    public static void main(String[] args) {

        Configuration configuration =
                new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory =
                configuration.buildSessionFactory();

        Session session =
                sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person = new Person(12, "Andrei");
            Person person1 = new Person(33, "Imantai");
            Person person2 = new Person(29, "Almaz");
            Person person3 = new Person(19, "Tanirbergen");
            Person person4 = new Person(45, "Alexei");
            session.save(person4);
            session.save(person3);
            session.save(person2);
            session.save(person1);
            session.save(person);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
