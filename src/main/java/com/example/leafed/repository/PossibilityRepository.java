package com.example.leafed.repository;

import com.example.leafed.entities.Possibility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PossibilityRepository extends JpaRepository<Possibility,Long> {
}
