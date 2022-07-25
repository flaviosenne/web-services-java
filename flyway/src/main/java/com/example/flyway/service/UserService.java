package com.example.flyway.service;

import com.example.flyway.entity.Role;
import com.example.flyway.entity.RoleEnum;
import com.example.flyway.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {


    private final Repository repository;
    private final RoleRepository roleRepository;

    public User save(User user, String[] roles){

        List<RoleEnum> rolesEnum = new ArrayList<>();

        for(String role: roles){
            rolesEnum.add(RoleEnum.getRole(role));
        }

        if(rolesEnum.size() == 0) throw new RuntimeException("role is not provider");

        List<Role> rolesEntity = rolesEnum.stream()
                .map(role -> roleRepository.findById(role.getCode())
                        .orElse(null)).collect(Collectors.toList()).stream()
                .filter(Objects::isNull).collect(Collectors.toList());

        return repository.save(user.withRoles(rolesEntity));
    }
}
