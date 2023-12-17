package com.example.clinicpetsapp.Validation;

import com.example.clinicpetsapp.domain.PetOwner;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PetOwnerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PetOwner.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PetOwner petOwner = (PetOwner) target;

        // Example validation logic for mobile number
        String mobileNumber = petOwner.getOwnerTelephoneNumber();
        if (mobileNumber != null && !mobileNumber.matches("[0-9]+")) {
            errors.rejectValue("ownerTelephoneNumber", "InvalidFormat.ownerTelephoneNumber", "Invalid mobile number format");

        }
    }
}
