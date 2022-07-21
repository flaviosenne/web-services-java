package com.example.event.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    private String username;
    private String email;
    private String password;
}
