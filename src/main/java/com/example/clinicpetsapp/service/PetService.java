package com.example.clinicpetsapp.service;


import com.example.clinicpetsapp.domain.Pet;
import com.example.clinicpetsapp.repository.PetOwnerRepo;
import com.example.clinicpetsapp.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepo petRepo;

    public String savePetInfo(Pet pet){
        if(pet!=null){
            petRepo.save(pet);
            return "pet saved successfully";
        } else {
            return null;
        }
    }
    public List<Pet> displayAllPets() {
        return petRepo.findAll();

    }
    public boolean PetExist(Long code) {
        return petRepo.existsById(code);
    }

    public String deletePet(Long id) {
        if (id != null) {
            petRepo.deleteById(id);
            return "pet deleted successfully";
        } else {
            return "No pet available to delete";

        }

    }

    public String updatePet(Long id) {
        if (id != null) {
            Optional<Pet> pet1 = petRepo.findById(id);
            if (pet1.isPresent()) {
                Pet pet = pet1.get();
                pet.setPetName("Labrador");
                pet.setPetType("dog");
                pet.setPetBreed("workingDogs");
                pet.setPetArrivalDate(LocalDate.parse("12/11/2020"));
                pet.getPetOwner().setOwnerLastName("Maluma");

                return "pet updated successfully";
            } else {
                return "No pet found with the given ID";
            }

        } else {
            return "invalid ID";
        }
    }
    public Pet getPetByCode(Long petCode){
        return petRepo.findById(petCode).orElse(null);
    }
}

