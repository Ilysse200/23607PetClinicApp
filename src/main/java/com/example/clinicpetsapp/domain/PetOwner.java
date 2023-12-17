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
public class PetOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ownerId;

    private String ownerFirstName;

    private String ownerLastName;

    @Column(name = "mobileNumber")
    private String OwnerTelephoneNumber;

    @Column(name = "cityOfLocation")
    private String ownerCity;

    public PetOwner(String ownerFirstName, String ownerLastName, String ownerTelephoneNumber, String ownerCity) {
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        OwnerTelephoneNumber = ownerTelephoneNumber;
        this.ownerCity = ownerCity;
    }
}
