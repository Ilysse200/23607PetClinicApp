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

public class AppointmentInformation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentID;

    private LocalDate appointmentDate;

    private String appointmentReason;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Veterinarian veterinarian;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ownerAppointment")
    private PetOwner petOwner;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "petAppointment")
    private Pet pet;

    public AppointmentInformation(LocalDate appointmentDate, String appointmentReason) {
        this.appointmentDate = appointmentDate;
        this.appointmentReason = appointmentReason;
    }

    //    public void setPet(String petName) {
//        if (pet == null) {
//            pet = new Pet(); // Initialize if not already created
//        }
//        pet.setPetName(petName);
//    }

//    public void setVeterinarian(String veterinarian1) {
//        if (veterinarian == null) {
//            veterinarian = new Veterinarian(); // Initialize if not already created
//        }
//        veterinarian.setVetName(veterinarian1);
//    }
//    public void setPetOwner(String petOwnerName) {
//        if (petOwner == null) {
//            petOwner = new PetOwner(); // Initialize if not already created
//        }
//        petOwner.setOwnerLastName(petOwnerName);
//    }
}
