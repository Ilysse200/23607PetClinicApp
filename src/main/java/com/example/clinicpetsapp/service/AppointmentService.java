package com.example.clinicpetsapp.service;

import com.example.clinicpetsapp.domain.AppointmentInformation;
import com.example.clinicpetsapp.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;

    public String saveAppointmentInfo(AppointmentInformation appointmentInformation){
        if(appointmentInformation!=null){
            appointmentRepo.save(appointmentInformation);
            return "appointment saved successfully";
        } else {
            return null;
        }
    }
    public List<AppointmentInformation> displayAllAppointments() {
        return appointmentRepo.findAll();

    }
    public boolean AppointmentExist(Long code) {
        return appointmentRepo.existsById(code);
    }

    public String deleteAppointment(Long id) {
        if (id != null) {
            appointmentRepo.deleteById(id);
            return "appointment deleted successfully";
        } else {
            return "No appointment available to delete";

        }

    }

    public String updateAppointments(Long id) {
        if (id != null) {
            Optional<AppointmentInformation> appointment = appointmentRepo.findById(id);
            if (appointment.isPresent()) {

                AppointmentInformation appointmentInformation = appointment.get();
                appointmentInformation.setAppointmentDate(LocalDate.parse("11/01/2004"));
                appointmentInformation.setAppointmentReason("surgery");
                appointmentInformation.getPet().setPetName("Box");
                appointmentInformation.getVeterinarian().setVetName("Alexander");
                appointmentInformation.getPetOwner().setOwnerFirstName("Mc Call");

                return "appointment updated successfully";
            } else {
                return "No appointment found with the given ID";
            }

        } else {
            return "invalid ID";
        }
    }
    public AppointmentInformation getAppointmentByCode(Long appointmentCode){
        return appointmentRepo.findById(appointmentCode).orElse(null);
    }
}

