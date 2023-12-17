package com.example.clinicpetsapp.repository;

import com.example.clinicpetsapp.domain.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepo extends JpaRepository<Veterinarian, Long> {
}
