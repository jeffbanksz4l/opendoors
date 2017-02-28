package opendoors.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

import opendoors.objects.Users;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author jeffb
 */
@Component
public class UsersValidator implements Validator {

    private static final Logger logger = Logger.getLogger(UsersValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Users.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Username", "users.Username.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Password", "users.Password.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Enabled", "users.Enabled.required");

        Users users = (Users) target;
        if (users.getUsername().length() > 45) {
            errors.rejectValue("Username", "users.Username.length");
        }

        if (!users.getUsername().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("Username", "users.Username.pattern");
        }

        if (users.getPassword().length() <= 8 && users.getPassword().length() >= 12) {
            errors.rejectValue("Password", "users.Password.length");
        }

        if (!users.getPassword().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("Password", "users.Password.pattern");
        }

//        if (users.getEnabled().length() > 1) {
//            errors.rejectValue("Enabled", "users.Enabled.length");
//        }
//
//        if (!users.getEnabled().matches("^[E||U]*$")) {
//            errors.rejectValue("Enabled", "users.Enabled.pattern");
//        }
    }

}
