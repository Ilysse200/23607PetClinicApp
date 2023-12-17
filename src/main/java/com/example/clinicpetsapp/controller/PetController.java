package com.example.clinicpetsapp.controller;

import com.example.clinicpetsapp.domain.Pet;
import com.example.clinicpetsapp.domain.PetOwner;
import com.example.clinicpetsapp.service.OwnerService;
import com.example.clinicpetsapp.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String listPets(@RequestParam(name = "petId", required = false) Long petId,
                           @PageableDefault(size = 3, sort = "petName") Pageable pageable,
                           Model model) {
        if (petId != null) {
            // Search by petId
            Pet pet = petService.getPetByCode(petId);
            if (pet != null) {
                model.addAttribute("pets", List.of(pet));
            } else {
                model.addAttribute("pets", List.of()); // Empty list for no results
            }
        } else {
            // Display all pets with pagination
            Page<Pet> petPage = petService.displayAllPets(pageable);
            model.addAttribute("pets", petPage.getContent());
            model.addAttribute("page", petPage);
        }

        // Other logic for displaying all pets or searched pets

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
        return "edit_pet";

    }

    @PostMapping("/pets/{id}")
    public  String updatePets(@PathVariable Long id,
                               @ModelAttribute("pet") Pet pet,@ModelAttribute("ownerL")  Model model){
        List<PetOwner> listOwner = ownerService.displayAllOwners();
//        model.addAttribute("ownerL", listOwner);

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
    public String deletePets(@PathVariable Long id, Model model) {
        try {
            petService.deletePet(id);
        } catch (DataIntegrityViolationException e) {
            // Handle foreign key constraint violation (delete error)
            model.addAttribute("error", "Cannot delete pet. It may be associated with other records.");
            return "error"; // Return the error page
        }
        return "redirect:/pets";
    }

    // Exception handler for general exceptions
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("error", "An unexpected error occurred.");
        return "error"; // Return the error page
    }
}
