package com.example.clinicpetsapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vetId")
    public Long veterinarianCode;

    @Column(name = "veterinarianFullNames")
    public  String vetName;

    @Column(name = "telNumber")
    public String vetContactInfo;

    @Column(name = "areaOfExpertise")
    public String vetSpecialty;


}
