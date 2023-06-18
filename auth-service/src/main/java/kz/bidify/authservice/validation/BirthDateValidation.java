package kz.bidify.authservice.validation;

import java.time.LocalDate;
import java.time.Period;

public class BirthDateValidation {

    public static boolean isValid(LocalDate birthDate) {
        LocalDate now = LocalDate.now();
        int age = Period.between(birthDate, now).getYears();
        return age >= 18;
    }
}
