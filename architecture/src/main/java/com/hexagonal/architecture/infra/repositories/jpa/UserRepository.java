package com.hexagonal.architecture.infra.repositories.jpa;

import com.hexagonal.architecture.infra.config.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
