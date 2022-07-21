package com.example.event.controller;

import com.example.event.events.AuditEventPublisher;
import com.example.event.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuditEventPublisher eventPublisher;

    @PostMapping
    public void register(@RequestBody User user){
        eventPublisher.publishEvent("User saved with success !!! "+ user.getUsername());
    }
}
