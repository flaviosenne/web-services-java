package com.hexagonal.architecture.domain.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String cpfCnpj;
    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPhone() {
        return phone;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
