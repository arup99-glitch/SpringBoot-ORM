package com.academy.hdemo.dao;

import com.academy.hdemo.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Qualifier("AccountDAOImp2")
public class AccountDAOImp2 implements AccountDAO{

    /*Spring Data JPA initializes JPA EntityManagerFactory for persistence unit ‘default’.
   Actual type of the entityManager object would be LocalContainerEntityManagerFactoryBean
   which wraps a Hibernate’s Session object.*/

    @Autowired
    private EntityManager entityManager;

/*     @PersistenceContext
    private EntityManager entityManager;*/

    @Override
    @Transactional
    public void save(Account account) {
        entityManager.persist(account);
    }

    @Override
    public Account findByAccountId(long id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    @Transactional
    public void delete(Account account) {
        Account contact = entityManager.find(Account.class, account.getAccountId());
        entityManager.remove(contact);
    }

    @Override
    @Transactional
    public void update(Account account) {
        entityManager.merge(account);
    }

    @Override
    public List<Account> accountList() {
        String jpql = "SELECT c FROM Account c";
        TypedQuery<Account> query = entityManager.createQuery(jpql, Account.class);
        return query.getResultList();
    }

}
