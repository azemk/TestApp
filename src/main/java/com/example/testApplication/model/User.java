package com.example.testApplication.model;

import javax.persistence.*;

@Entity
@Table(name ="user_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    @Column(name ="username ", nullable =false,unique = true)
    private String username ;
    @Column(name ="password",nullable = false,unique = true)
    private String password;
    @Column(name ="is_active")
    private int isActive;

    public User() {
        this.isActive = 1;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isActive = 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
