package com.example.testApplication.service;

import com.example.testApplication.model.Payment;

import java.util.List;

public interface PaymentService {

    public Payment create (Payment payment );
    public Payment update (Payment payment );
    public List<Payment> getAll();
    void findById(Long id );
    void deleteById(Long id );
}
