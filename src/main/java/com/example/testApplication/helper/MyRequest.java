package com.example.testApplication.helper;

import java.time.LocalDateTime;

public class MyRequest {
    private Long id ;
    private Long supplier_id;
    private Long account;
    private Double amount;
    private String command;
    private LocalDateTime date;

    public MyRequest() {
    }

    public MyRequest(Long id, Long supplier_id, Long account, Double amount, String command ,LocalDateTime time) {
        this.id = id;
        this.supplier_id = supplier_id;
        this.account = account;
        this.amount = amount;
        this.command = command;
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

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
