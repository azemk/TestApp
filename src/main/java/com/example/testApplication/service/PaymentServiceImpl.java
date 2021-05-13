package com.example.testApplication.service;

import com.example.testApplication.model.Account;
import com.example.testApplication.model.Payment;
import com.example.testApplication.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    AccountService accountService;

    @Override
    public Payment create(Payment payment) {
        Account account = accountService.check(payment.getAccount().getAccount());
        account.setBalance(account.getBalance()-payment.getAmount());
        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void findById(Long id) {
        paymentRepository.findById(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }
}
