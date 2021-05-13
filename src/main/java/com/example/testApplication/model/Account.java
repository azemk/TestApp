package com.example.testApplication.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts" )
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name="account", nullable = false,unique = false)
    private Long account;

    @Column(name ="balance" )
    private Double balance ;

    public Account() {

    }

    public Account(Long account, Double balance) {
        this.account = account;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
