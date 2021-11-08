package com.hexagonal.architecture.app.controllers;

import com.hexagonal.architecture.app.dtos.UserDto;
import com.hexagonal.architecture.domain.entity.User;
import com.hexagonal.architecture.domain.protocols.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserServiceInterface userServiceInterface;


    @PostMapping
    public void create(@RequestBody UserDto dto){
        User entity = new UserDto().toUser(dto);
        userServiceInterface.add(entity);
    }

    @GetMapping
    public List<User> get(){
        return userServiceInterface.findAll();
    }
}
