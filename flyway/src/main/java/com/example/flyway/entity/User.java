package com.example.flyway.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Builder
@Entity
@Table(name = "users")
public class User {
    private String id;
    private String username;
    private String email;
    private String password;
    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Role> roles;

    public User withRoles(List<Role> roles){
        this.roles = roles;
        return this;
    }
}
