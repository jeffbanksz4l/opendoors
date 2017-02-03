package opendoors.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

import opendoors.objects.Clients;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author jeffb
 */
@Component
public class ClientsValidator implements Validator {

    private static final Logger logger = Logger.getLogger(ClientsValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Clients.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "First_Name", "clients.First_Name.required");

        Clients clients = (Clients) target;
        if (clients.getFirst_Name().length() > 45) {
            errors.rejectValue("First_Name", "clients.First_Name.length");
        }

        if (!clients.getFirst_Name().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("First_Name", "clients.First_Name.pattern");
        }
    }

}
