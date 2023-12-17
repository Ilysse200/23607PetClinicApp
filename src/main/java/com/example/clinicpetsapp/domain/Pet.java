package com.example.clinicpetsapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    private String petName;

    private String petBreed;

    private LocalDate petArrivalDate;

    private String petType;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private PetOwner petOwner;


//    public void setPetOwner(String petOwnerName) {
//        if (petOwner == null) {
//            petOwner = new PetOwner(); // Initialize if not already created
//        }
//        petOwner.setOwnerLastName(petOwnerName);
//    }

    public Pet(String petName, String petBreed, LocalDate petArrivalDate, String petType) {
        this.petName = petName;
        this.petBreed = petBreed;
        this.petArrivalDate = petArrivalDate;
        this.petType = petType;
    }
}
