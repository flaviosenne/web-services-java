package com.example.flyway.service;

import com.example.flyway.entity.Role;
import com.example.flyway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
