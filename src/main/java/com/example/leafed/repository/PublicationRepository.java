package com.example.leafed.repository;

import com.example.leafed.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
