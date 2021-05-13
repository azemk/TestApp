package com.example.testApplication.controller;


import com.example.testApplication.helper.MyRequest;
import com.example.testApplication.helper.RequestWrapper;
import com.example.testApplication.helper.Response;
import com.example.testApplication.model.Account;
import com.example.testApplication.model.Payment;
import com.example.testApplication.model.User;
import com.example.testApplication.model.UserRole;
import com.example.testApplication.repository.PaymentRepository;
import com.example.testApplication.service.AccountService;
import com.example.testApplication.service.UserRoleService;
import com.example.testApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping(value = "/payments", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Response Requests(@RequestBody RequestWrapper requestWrapper) throws Exception {

        try {
            MyRequest request = requestWrapper.getRequest();
            Account account = accountService.check(request.getAccount());
            Payment p = paymentRepository.save(new Payment(request.getSupplier_id(),account,request.getAmount(),request.getDate()));
            if (request.getCommand().equals("pay")) {

                return new Response(p.getId(), p.getId(), 0, "PAYMENT CONFIRMED");
            } else if (request.getCommand().equals("check")) {
                if(account!=null){
                    return new Response(122231l, p.getId(), 1, "ACCOUNT EXISTS");
                }else {
                    return new Response(122231l, p.getId(), 0, "ACCOUNT DOESN'T EXIST");
                }
            } else {
                return new Response(122231l, null, -1, "COMMAND NOT UNDERSTOOD");
            }


        } catch (DataIntegrityViolationException exception) {
            exception.printStackTrace();
            return new Response(1212131l, null, -1, "UNEXPECTED ERROR!");
        }
    }










    @Secured({"ROLE_USER"
            , "ROLE_ADMIN"})
    @GetMapping("/getAllUsers")
    public List<User> getAll(){
        return userService.getAll();
    }
    @Secured("ROLE_ADMIN")
    @PostMapping("/updateUsers")
    public User update(@RequestBody User user){
        return userService.update(user);
    }
    @Secured("ROLE_ADMIN")
    @PostMapping("/createUsers")
    public User create (@RequestBody User user){
        return userService.create(user);
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping("/deleteUsers/{id}")
    public void deleteById (@PathVariable Long id){
        userService.deleteById(id);
    }
    @PostMapping("/createRoles")
    public UserRole create (@RequestBody UserRole userRole){
        return userRoleService.create(userRole);
    }
    @PostMapping("/updateRoles")
    public UserRole update (@RequestBody UserRole userRole){
        return userRoleService.update(userRole);
    }
    @DeleteMapping("/deleteRole/{id}")
    public void delete(@PathVariable Long id ){
        userRoleService.deleteById(id);

    }




}
