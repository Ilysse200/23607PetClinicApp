package com.example.clinicpetsapp.controller;

import com.example.clinicpetsapp.domain.PetOwner;
import com.example.clinicpetsapp.domain.Veterinarian;
import com.example.clinicpetsapp.service.VeterinarianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VeterinarianController {
    private VeterinarianService veterinarianService;

    public VeterinarianController(VeterinarianService veterinarianService) {
        this.veterinarianService = veterinarianService;
    }
    @GetMapping("/veterinarians")
    public String listVeterinarians(Model model){
        model.addAttribute("veterinarians", veterinarianService.displayAllVeterinarians());
        return "veterinarians";

    }
    @GetMapping("/veterinarians/new")
    public String createVeterinariansForm(Model model){
        //create veterinarian object to hold owner form data
        Veterinarian veterinarian = new Veterinarian();
        model.addAttribute("veterinarian", veterinarian);
        return "create_veterinarian";

    }

    @PostMapping("/veterinarians")
    public  String saveVeterinarians(@ModelAttribute("veterinarian") Veterinarian veterinarian){
        veterinarianService.saveVeterinarianInfo(veterinarian);
        return "redirect:/veterinarians";

    }

    @GetMapping("/veterinarians/edit/{id}")
    public String editVeterinariansForm(@PathVariable Long id, Model model){
        model.addAttribute("veterinarian", veterinarianService.getVeterinariansByCode(id) );
        return "edit_veterinarian";

    }

    @PostMapping("/veterinarians/{id}")
    public  String updateVeterinarians(@PathVariable Long id,
                               @ModelAttribute("veterinarian") Veterinarian veterinarian, Model model){

        // get owner from database by id
        Veterinarian existingVeterinarian = veterinarianService.getVeterinariansByCode(id); // Update to getPetOwnerByCode
        existingVeterinarian.setVeterinarianCode(id);
        existingVeterinarian.setVetName(veterinarian.getVetName());
        existingVeterinarian.setVetContactInfo(veterinarian.getVetContactInfo());
        existingVeterinarian.setVetSpecialty(veterinarian.getVetSpecialty());



        //save the updated veterinarian object
        veterinarianService.saveVeterinarianInfo(existingVeterinarian);

        return "redirect:/veterinarians";

    }

    @GetMapping("/veterinarians/{id}")
    public  String deleteVeterinarians(@PathVariable Long id){
        veterinarianService.deleteVeterinarian(id);
        return "redirect:/veterinarians";

    }
}
