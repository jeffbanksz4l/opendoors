package opendoors.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

import opendoors.objects.Interactions;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author jeffb
 */
@Component
public class InteractionsValidator implements Validator {

    private static final Logger logger = Logger.getLogger(InteractionsValidator.class.getName());

    @Override
    public boolean supports(Class<?> clazz) {
        return Interactions.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Date_Of_Contact", "interaction.Date_Of_Contact.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Contact_Name", "interaction.Contact_Name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Contact_Type", "interaction.Contact_Type.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Conversations", "interaction.Conversations.required");

        Interactions interactions = (Interactions) target;
        if (interactions.getDate_Of_Contact().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("Date_Of_Contact", "interactions.Date_Of_Contact.pattern");
        }
    }

}
