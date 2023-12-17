package com.example.clinicpetsapp.controller;

import com.example.clinicpetsapp.domain.Pet;
import com.example.clinicpetsapp.domain.PetOwner;
import com.example.clinicpetsapp.service.OwnerService;
import com.example.clinicpetsapp.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PetController {

    private PetService petService;

    private OwnerService ownerService;

    @Autowired
    public PetController(PetService petService, OwnerService ownerService) {
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @GetMapping("/pets")
    public String listPets(Model model){
        model.addAttribute("pets", petService.displayAllPets());
        return "pets";

    }

    @GetMapping("/pets/new")
    public String createPetForm(Model model){
        //create pet object to hold owner form data
        Pet pet = new Pet();
        model.addAttribute("pet", pet);

        //Display the PetOwner

        List<PetOwner> owners = ownerService.displayAllOwners();
        model.addAttribute("ownerList", owners);
        return "create_pet";

    }

    @PostMapping("/pets")
    public  String savePet(@ModelAttribute("pet") Pet pet){
        petService.savePetInfo(pet);
        return "redirect:/pets";

    }

    @GetMapping("/pets/edit/{id}")
    public String editPetsForm(@PathVariable Long id, Model model){
        model.addAttribute("pet", petService.getPetByCode(id) );

        List<PetOwner> listOwner = ownerService.displayAllOwners();
        model.addAttribute("ownerL", listOwner);

        return "edit_pet";

    }

    @PostMapping("/pets/{id}")
    public  String updatePets(@PathVariable Long id,
                               @ModelAttribute("pet") Pet pet, Model model){


        // Get the pet from the database by id
        Pet existingPet = petService.getPetByCode(id); // Update to getPetByCode
        existingPet.setPetId(id);
        existingPet.setPetName(pet.getPetName());
        existingPet.setPetType(pet.getPetType());
        existingPet.setPetBreed(pet.getPetBreed());
        existingPet.setPetArrivalDate(pet.getPetArrivalDate());
        existingPet.setPetOwner(pet.getPetOwner());


        //save the updated pet object
        petService.savePetInfo(existingPet);

        return "redirect:/pets";

    }

    @GetMapping("/pets/{id}")
    public  String deletePets(@PathVariable Long id){
        petService.deletePet(id);
        return "redirect:/pets";

    }
}
