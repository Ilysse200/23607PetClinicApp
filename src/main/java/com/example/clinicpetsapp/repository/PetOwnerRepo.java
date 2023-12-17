package com.example.clinicpetsapp.repository;

import com.example.clinicpetsapp.domain.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PetOwnerRepo extends JpaRepository<PetOwner, Long> {

}
