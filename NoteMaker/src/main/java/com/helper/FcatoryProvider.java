package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FcatoryProvider {

    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null){
            sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
            return sessionFactory;
    }
}
