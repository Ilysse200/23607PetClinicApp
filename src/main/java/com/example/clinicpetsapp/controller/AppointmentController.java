package com.example.clinicpetsapp.controller;

import com.example.clinicpetsapp.domain.AppointmentInformation;
import com.example.clinicpetsapp.domain.Pet;
import com.example.clinicpetsapp.domain.PetOwner;
import com.example.clinicpetsapp.domain.Veterinarian;
import com.example.clinicpetsapp.service.AppointmentService;
import com.example.clinicpetsapp.service.OwnerService;
import com.example.clinicpetsapp.service.PetService;
import com.example.clinicpetsapp.service.VeterinarianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppointmentController {

    private AppointmentService appointmentService;

    private PetService petService;
    private OwnerService ownerService;
    private VeterinarianService veterinarianService;


    public AppointmentController(AppointmentService appointmentService, PetService petService, OwnerService ownerService, VeterinarianService veterinarianService) {
        this.appointmentService = appointmentService;
        this.petService = petService;
        this.ownerService = ownerService;
        this.veterinarianService = veterinarianService;
    }

    @GetMapping("/appointments")
    public String listOwners(Model model){
        model.addAttribute("appointments", appointmentService.displayAllAppointments());
        return "appointments";

    }

    @GetMapping("/appointments/new")
    public String createAppointmentsForm(Model model){
        //create appointment object to hold appointments form data
        AppointmentInformation appointmentInformation = new AppointmentInformation();
        model.addAttribute("appointment", appointmentInformation);


        //create a list of Veterinarian

        List<Veterinarian> vetList = veterinarianService.displayAllVeterinarians();
        model.addAttribute("veterinary", vetList);

        //create a list of petOwners
        List<PetOwner> ownerList = ownerService.displayAllOwners();
        model.addAttribute("listOwners", ownerList);

        //create a list of pets

        List<Pet> pets = petService.displayAllPets();
        model.addAttribute("petlist", pets);



        return "create_appointment";

    }

    @PostMapping("/appointments")
    public  String saveAppointments(@ModelAttribute("appointment") AppointmentInformation appointmentInformation){
        appointmentService.saveAppointmentInfo(appointmentInformation);
        return "redirect:/appointments";

    }

    @GetMapping("/appointments/edit/{id}")
    public String editAppointmentsForm(@PathVariable Long id, Model model){
        model.addAttribute("appointment", appointmentService.getAppointmentByCode(id) );


        List<Veterinarian> veterinaryL = veterinarianService.displayAllVeterinarians();
        model.addAttribute("vets", veterinaryL);

        //create a list of petOwners
        List<PetOwner> owners = ownerService.displayAllOwners();
        model.addAttribute("owners", owners);

        //create a list of pets

        List<Pet> pets = petService.displayAllPets();
        model.addAttribute("pets", pets);
        return "edit_appointment";

    }

    @PostMapping("/appointments/{id}")
    public  String updateAppointments(@PathVariable Long id,
                               @ModelAttribute("appointment") AppointmentInformation appointmentInformation, Model model){

        // get appointment from database by id

        AppointmentInformation existingAppointment = appointmentService.getAppointmentByCode(id);
        existingAppointment.setAppointmentID(id);
        existingAppointment.setAppointmentDate(appointmentInformation.getAppointmentDate());
        existingAppointment.setAppointmentReason(appointmentInformation.getAppointmentReason());
        existingAppointment.setPet(appointmentInformation.getPet());
        existingAppointment.setVeterinarian(appointmentInformation.getVeterinarian());
        existingAppointment.setPetOwner(appointmentInformation.getPetOwner());



        //save the updated appointment object
        appointmentService.saveAppointmentInfo(existingAppointment);

        return "redirect:/appointments";

    }

    @GetMapping("/appointments/{id}")
    public  String deleteAppointments(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";

    }

}
