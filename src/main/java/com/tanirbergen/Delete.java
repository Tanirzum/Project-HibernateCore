package com.tanirbergen;

import com.tanirbergen.Model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {
        Configuration configuration =
                new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory =
                configuration.buildSessionFactory();

        Session session =
                sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            session.delete(person);

            Person person1 = session.get(Person.class, 4);
            session.delete(person1);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
