package com.academy.hdemo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    @Id

    @Column(name = "account_id")
    private long accountId;
    private String firstName;

    @Column(name = "last_name")
    private String secondName;
    @Column(nullable = true)
    private Long balance;

    public Account() {
    }

    public Account(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Account(long accountId, String firstName, String secondName) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

}
