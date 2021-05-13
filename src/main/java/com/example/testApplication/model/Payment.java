package com.example.testApplication.model;

import com.example.testApplication.model.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name= "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name ="supplier_id" )
    private Long supplier_id;

    @ManyToOne(optional=true)
    @JoinColumn(name ="account")
    private Account account ;

    @Column(name="amount" )
    private Double amount;

    @Column(name = "date" )
    private LocalDateTime date;

    public Payment() {

    }

    public Payment(Long supplier_id, Account account, Double amount,LocalDateTime date) {
        this.supplier_id = supplier_id;
        this.account = account;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime() {
        return date;
    }

    public void setTime(LocalDateTime time) {
        this.date = date;
    }
}
