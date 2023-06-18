package kz.bidify.authservice.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {

    private static final String PASSWORD_PATTERN;

    static {
        PASSWORD_PATTERN = "[a-zA-Z0-9~!@#$%^&*]{8,20}$";
    }

    public static boolean isValid(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
