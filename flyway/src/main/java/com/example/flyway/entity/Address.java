package com.example.flyway.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Builder
@Entity
@Table(name = "address")
public class Address {
    private String id;
    private String street;
    private Integer number;
    @Column(name = "postal_code")
    private String postalCode;
    private String neighborhood;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
