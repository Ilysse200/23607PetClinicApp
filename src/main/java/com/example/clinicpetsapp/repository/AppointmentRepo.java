package com.example.clinicpetsapp.repository;

import com.example.clinicpetsapp.domain.AppointmentInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentInformation, Long> {
}
