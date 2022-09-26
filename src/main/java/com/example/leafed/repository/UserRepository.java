package com.example.leafed.repository;

import com.example.leafed.entities.UserAuthentification;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserAuthentification,Long> {
    Optional<UserAuthentification> findByUsername(String username);
}
