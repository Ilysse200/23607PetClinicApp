package com.example.clinicpetsapp;

import com.example.clinicpetsapp.domain.AppointmentInformation;
import com.example.clinicpetsapp.domain.Pet;
import com.example.clinicpetsapp.domain.PetOwner;
import com.example.clinicpetsapp.domain.Veterinarian;
import com.example.clinicpetsapp.repository.AppointmentRepo;
import com.example.clinicpetsapp.repository.PetOwnerRepo;
import com.example.clinicpetsapp.repository.PetRepo;
import com.example.clinicpetsapp.repository.VeterinarianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ClinicPetsAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClinicPetsAppApplication.class, args);
    }

    @Autowired
    private PetOwnerRepo ownerRepo;

    @Autowired
    private VeterinarianRepo veterinarianRepo;

    @Autowired
    private PetRepo petRepo;

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Override
    public void run(String... args) throws Exception {
//        PetOwner petOwner = new PetOwner("Wanda", "Ruzindana", "+250787255285", "kigali");
//        ownerRepo.save(petOwner);
//
//        PetOwner petOwner1 = new PetOwner("Tom", "Stark", "+3037890134", "BeverlyHills");
//        ownerRepo.save(petOwner1);
//
//        PetOwner petOwner2 = new PetOwner("Maclynn", "Kabanda", "+253037890134", "Kigali");
//        ownerRepo.save(petOwner2);


//        PetOwner petOwner = new PetOwner();
//        Pet pet = new Pet("Michou", "Boxes", LocalDate.now(), "Dog");
//
//        petOwner.setOwnerFirstName("Maltin");
//        petOwner.setOwnerLastName("McLaynn");
//        petOwner.setOwnerTelephoneNumber("+11089456789");
//        petOwner.setOwnerCity("NewJersey");
//
//        pet.setPetOwner(petOwner);
//        petRepo.save(pet);
//
//
//        PetOwner petOwner1 = new PetOwner();
//
//        petOwner1.setOwnerFirstName("Klaus");
//        petOwner1.setOwnerLastName("Mikaelson");
//        petOwner1.setOwnerTelephoneNumber("110000456789");
//        petOwner1.setOwnerCity("BeaconHills");
//
//        Pet pet1 = new Pet("Maltou", "GoldenRetriever", LocalDate.now(), "Dog");
//        pet1.setPetOwner(petOwner1);
//        petRepo.save(pet1);




//
//
//
//


//        PetOwner petOwner = new PetOwner();
//
//        petOwner.setOwnerFirstName("Kalixte");
//        petOwner.setOwnerLastName("Karl");
//        petOwner.setOwnerTelephoneNumber("5034567890");
//        petOwner.setOwnerCity("DenMark");
//
//        PetOwner petOwner1 = new PetOwner();
//        petOwner1.setOwnerFirstName("Malcolm");
//        petOwner1.setOwnerLastName("Santos");
//        petOwner1.setOwnerTelephoneNumber("40038887890");
//        petOwner1.setOwnerCity("kigali");
//
//
//        Pet pet = new Pet();
//        pet.setPetName("pisky");
//        pet.setPetBreed("GoldenRetriever");
//        pet.setPetArrivalDate(LocalDate.now());
//        pet.setPetType("Dog");
//
//        pet.setPetOwner(petOwner);
//
////
////
//        Pet pet1 = new Pet();
//        pet1.setPetOwner(petOwner1);
//
//        pet1.setPetName("pushka");
//        pet1.setPetBreed("chiwawa");
//        pet1.setPetArrivalDate(LocalDate.now());
//        pet1.setPetType("Dog");



//        Veterinarian veterinarian = new Veterinarian();
//        veterinarian.setVetName("Malut");
//        veterinarian.setVetContactInfo("malut@gmail.com");
//        veterinarian.setVetSpecialty("bacteriology");
//
//        veterinarianRepo.save(veterinarian);
//
//
//        Veterinarian veterinarian1 = new Veterinarian();
//        veterinarian.setVetName("Luna");
//        veterinarian.setVetContactInfo("luna@gmail.com");
//        veterinarian.setVetSpecialty("urology");
//
//        veterinarianRepo.save(veterinarian1);

//        AppointmentInformation appointmentInformation = new AppointmentInformation(LocalDate.now(), "healthcheck");
//        appointmentInformation.setPetOwner(petOwner);
//        appointmentInformation.setVeterinarian(veterinarian);
//        appointmentInformation.setPet(pet);
//
//        appointmentRepo.save(appointmentInformation);
//
//
//        AppointmentInformation appointmentInformation1 = new AppointmentInformation(LocalDate.now(), "feverCheck");
//
//        appointmentInformation1.setPetOwner(petOwner1);
//        appointmentInformation1.setVeterinarian(veterinarian1);
//        appointmentInformation1.setPet(pet1);
//
//        appointmentRepo.save(appointmentInformation1);




    }
}
