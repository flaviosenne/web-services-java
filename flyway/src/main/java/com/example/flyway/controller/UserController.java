package com.example.flyway.controller;

import com.example.flyway.entity.User;
import com.example.flyway.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/users")
@Controller
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity save(@RequestBody User user, @RequestParam("roles") String roles){
        service.save(user, roles.split(","));
        return ResponseEntity.ok().build();
    }

}
