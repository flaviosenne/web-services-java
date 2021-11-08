package com.hexagonal.architecture.domain.protocols;

import com.hexagonal.architecture.domain.entity.User;

import java.util.List;

public interface UserServiceInterface {
    void add(User user);
    List<User> findAll();
}
