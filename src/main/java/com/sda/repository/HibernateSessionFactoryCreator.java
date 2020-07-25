package com.sda.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactoryCreator {

  private static SessionFactory sessionFactory;

  static {
    StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml")
        .build();
    sessionFactory = new MetadataSources(standardServiceRegistry)
        .buildMetadata()
        .buildSessionFactory();
  }
  public  static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
