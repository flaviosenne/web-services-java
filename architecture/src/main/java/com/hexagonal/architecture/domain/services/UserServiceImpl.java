package com.hexagonal.architecture.domain.services;

import com.hexagonal.architecture.domain.entity.User;
import com.hexagonal.architecture.domain.protocols.UserServiceInterface;
import com.hexagonal.architecture.domain.repository.UserRepositoryInterface;

import java.util.List;

public class UserServiceImpl implements UserServiceInterface {
    private UserRepositoryInterface repository;

    public UserServiceImpl(UserRepositoryInterface repository) {
        this.repository = repository;
    }

    public UserServiceImpl(){

    }

    @Override
    public void add(User user) {
        User entity = repository.save(user);

        System.out.println("Salvou "+ entity.getId());
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
