package com.example.testApplication.bootstrap;

import com.example.testApplication.model.Account;
import com.example.testApplication.model.User;
import com.example.testApplication.model.UserRole;
import com.example.testApplication.service.AccountService;
import com.example.testApplication.service.UserRoleService;
import com.example.testApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class MainBootstrap implements ApplicationRunner {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    AccountService accountService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        try{
            User user = new User("useer","123");
            UserRole ur = new UserRole("ROLE_USER", user );
            UserRole ur2 = new UserRole("ROLE_ADMIN", user );

            userService.create(user);
            userRoleService.create(ur);
            userRoleService.create(ur2);

            Account account = new Account(999777111222l,2000.0);
            accountService.create(account);
        }catch (DataIntegrityViolationException ex){
            System.out.println("ex: " + ex.getMessage());
        }
    }
}
