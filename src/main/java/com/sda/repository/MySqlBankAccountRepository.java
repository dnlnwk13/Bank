//package com.sda.repository;
//
//import com.sda.model.BankAccount;
//import com.sda.request.CreateBankAccountRequest;
//import lombok.NonNull;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//public class MySqlBankAccountRepository implements BankAccountRepository {
//
//  public boolean existsByPesel(@NonNull String pesel) {
//    SessionFactory sessionFactory = HibernateSessionFactoryCreator.getSessionFactory();
//    Session session = sessionFactory.openSession();
//    session.createQuery();
//    return false;
//  }
//
//  public BankAccount create(CreateBankAccountRequest request) {
//    SessionFactory sessionFactory = HibernateSessionFactoryCreator.getSessionFactory();
//    Session session = sessionFactory.openSession();
//    session.persist();
//  }
//}
