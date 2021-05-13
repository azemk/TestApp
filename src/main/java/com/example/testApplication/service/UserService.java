package com.example.testApplication.service;

import com.example.testApplication.model.User;

import java.util.List;

public interface UserService {
    public User create (User user);
    public User update (User user);
    public List<User> getAll();
    void deleteById(Long id );
}
