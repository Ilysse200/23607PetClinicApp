package com.example.clinicpetsapp.controller;

import com.example.clinicpetsapp.Validation.PetOwnerValidator;
import com.example.clinicpetsapp.domain.PetOwner;
import com.example.clinicpetsapp.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PetOwnerControlller {

    @Autowired
    private PetOwnerValidator petOwnerValidator;

    private OwnerService ownerService;


    public PetOwnerControlller(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public String listOwners(@RequestParam(name = "ownerId", required = false) Long ownerId, Model model) {
        if (ownerId != null) {
            // Search by ownerId
            PetOwner owner = ownerService.getPetOwnerByCode(ownerId);
            if (owner != null) {
                model.addAttribute("owners", List.of(owner));
            } else {
                model.addAttribute("owners", List.of()); // Empty list for no results
            }
        } else {
            // Display all owners
            model.addAttribute("owners", ownerService.displayAllOwners());
        }
        return "owners";

    }

    @GetMapping("/owners/new")
    public String createPetOwnerForm(Model model){
        //create owner object to hold owner form data
        PetOwner petOwner = new PetOwner();
        model.addAttribute("owner", petOwner);
        return "create_owner";

    }

    @PostMapping("/owners")
    public String savePetOwner(@ModelAttribute("owner") PetOwner petOwner, BindingResult result, Model model) {
        // Validate the petOwner object
        petOwnerValidator.validate(petOwner, result);

        // Check for validation errors
        if (result.hasErrors()) {
            return "create_owner"; // Return to the form page with validation errors
        }

        // If there are no validation errors, proceed with saving the owner
        ownerService.saveOwnerInfo(petOwner);
        return "redirect:/owners";
    }

    @GetMapping("/owners/edit/{id}")
    public String editOwnerForm(@PathVariable Long id, Model model){
        model.addAttribute("owner", ownerService.getPetOwnerByCode(id) );
        return "edit_owner";

    }

    @PostMapping("/owners/{id}")
    public String updateOwner(
            @PathVariable Long id,
            @ModelAttribute("owner") PetOwner petOwner,
            BindingResult result,
            Model model
    ) {
        // Validate the petOwner object
        petOwnerValidator.validate(petOwner, result);

        // Check for validation errors
        if (result.hasErrors()) {
            return "edit_owner"; // Return to the form page with validation errors
        }

        // If there are no validation errors, proceed with updating the owner
        PetOwner existingOwner = ownerService.getPetOwnerByCode(id);
        existingOwner.setOwnerId(id);
        existingOwner.setOwnerLastName(petOwner.getOwnerLastName());
        existingOwner.setOwnerFirstName(petOwner.getOwnerFirstName());
        existingOwner.setOwnerCity(petOwner.getOwnerCity());
        existingOwner.setOwnerTelephoneNumber(petOwner.getOwnerTelephoneNumber());

        ownerService.saveOwnerInfo(existingOwner);
        return "redirect:/owners";


    }

    @GetMapping("/owners/{id}")
    public String deleteOwner(@PathVariable Long id, Model model) {
        try {
            ownerService.deleteOwner(id);
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Cannot delete owner with associated pets. Remove the associated appointment first.");
            model.addAttribute("owners", ownerService.displayAllOwners());
            return "error";
        }
        return "redirect:/owners";
    }
    @ControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(DataIntegrityViolationException.class)
        public String handleDataIntegrityViolationException(
                DataIntegrityViolationException ex, Model model) {
            model.addAttribute("error", "Data integrity violation: " + ex.getMessage());
            return "error"; // You can customize the error page or redirect as needed
        }
    }



}
