package com.example.clinicpetsapp.service;

import com.example.clinicpetsapp.domain.Veterinarian;
import com.example.clinicpetsapp.repository.VeterinarianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarianService {
    @Autowired
    private VeterinarianRepo veterinarianRepo;
    public String saveVeterinarianInfo(Veterinarian veterinarian){
        if(veterinarian!=null){
            veterinarianRepo.save(veterinarian);
            return "veterinarian saved successfully";
        } else {
            return null;
        }
    }
    public List<Veterinarian> displayAllVeterinarians() {
        return veterinarianRepo.findAll();

    }
    public boolean VeterinarianExist(Long code) {
        return veterinarianRepo.existsById(code);
    }

    public String deleteVeterinarian(Long id) {
        if (id != null) {
            veterinarianRepo.deleteById(id);
            return "veterinarian deleted successfully";
        } else {
            return "No veterinarian available to delete";

        }

    }

    public String updateVeterinarian(Long id) {
        if (id != null) {
            Optional<Veterinarian> vet1 = veterinarianRepo.findById(id);
            if (vet1.isPresent()) {
                Veterinarian veterinarian = vet1.get();
                veterinarian.setVetName("Andrew");
                veterinarian.setVetContactInfo("+240567890234567");
                veterinarian.setVetSpecialty("genecology");

                return "veterinarian updated successfully";
            } else {
                return "No veterinarian found with the given ID";
            }

        } else {
            return "invalid ID";
        }
    }
    public Veterinarian getVeterinariansByCode(Long vetCode){
        return veterinarianRepo.findById(vetCode).orElse(null);
    }
}


