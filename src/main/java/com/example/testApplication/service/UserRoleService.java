package com.example.testApplication.service;


import com.example.testApplication.model.UserRole;

import java.util.List;

public interface UserRoleService {
    public UserRole create(UserRole userRole);
    public UserRole update (UserRole userRole);
    public List<UserRole> getAll();
    void deleteById(Long id);
}
