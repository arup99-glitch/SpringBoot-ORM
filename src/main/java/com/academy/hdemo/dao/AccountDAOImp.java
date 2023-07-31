package com.academy.hdemo.dao;

import com.academy.hdemo.dto.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("AccountDAOImp")
public class AccountDAOImp implements AccountDAO {

    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public void save(Account account) {
        Session session = this.sessionFactory.openSession();
        // start a transaction
        Transaction transaction = session.beginTransaction();
//        session.persist(account);
        Long id  = (Long) session.save(account);

        // commit transaction
        transaction.commit();
//
        session.close();
    }

    @Override
    public Account findByAccountId(long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Account account =session.get(Account.class, id);
        transaction.commit();
        session.close();
        return account;
    }

    @Override
    public void update(Account account) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(account);
//        session.saveOrUpdate(account);
//        session.merge(account);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Account account) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(account);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Account> accountList() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Account> accountList = session.createQuery("from Account").list();
        transaction.commit();
        session.close();
        return accountList;
    }

    //supports HQl

}
