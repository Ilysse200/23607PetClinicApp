package com.example.clinicpetsapp.service;


import com.example.clinicpetsapp.domain.PetOwner;
import com.example.clinicpetsapp.repository.PetOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private  PetOwnerRepo ownerRepo;

    public String saveOwnerInfo(PetOwner owner){
        if(owner!=null){
            ownerRepo.save(owner);
            return "owner saved successfully";
                } else {
                    return null;
                }
            }
            public List<PetOwner> displayAllOwners() {
                return ownerRepo.findAll();

            }
            public boolean OwnerExist(Long code) {
                return ownerRepo.existsById(code);
            }

            public String deleteOwner(Long id) {
                if (id != null) {
                    ownerRepo.deleteById(id);
                    return "owner deleted successfully";
                } else {
                    return "No owner available to delete";

                }

            }

            public String updateOwner(Long id) {
                if (id != null) {
                    Optional<PetOwner> owner = ownerRepo.findById(id);
                    if (owner.isPresent()) {
                        PetOwner owner1 = owner.get();
                        owner1.setOwnerFirstName("Harrold");
                        owner1.setOwnerCity("Kigali");
                        owner1.setOwnerLastName("McCall");
                        owner1.setOwnerTelephoneNumber("+250982345678");
//                    academY.getCourses();
                        ownerRepo.save(owner1);
                        return "Owner updated successfully";
                    } else {
                        return "No Owner found with the given ID";
                    }

                } else {
                    return "invalid ID";
                }
            }
            public PetOwner getPetOwnerByCode(Long ownCode){
                return ownerRepo.findById(ownCode).get();
            }
        }

