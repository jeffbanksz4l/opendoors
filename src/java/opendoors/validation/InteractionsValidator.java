package opendoors.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

import opendoors.objects.Interactions;
import java.util.logging.Logger;

/**
 *
 * @author jeffb
 */
@Component
public class InteractionsValidator implements Validator {

    private static final Logger logger = Logger.getLogger(InteractionsValidator.class.getName());

    /**
     * Boolean to check support
     *
     * @param clazz
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Interactions.class.isAssignableFrom(clazz);
    }

    /**
     * Validator for Interactions
     *
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Date_Of_Contact", "interaction.Date_Of_Contact.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Contact_First_Name", "interaction.Contact_First_Name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Contact_Last_Name", "interaction.Contact_Last_Name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Contact_Type", "interaction.Contact_Type.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Conversations", "interaction.Conversations.required");

        Interactions interactions = (Interactions) target;
        if (!interactions.getContact_First_Name().matches("^[a-zA-Z0-9-_. ]+$")) {
            errors.rejectValue("Contact_First_Name", "interactions.First_Name.pattern", "default");
        }

        if (!interactions.getContact_Last_Name().matches("^[a-zA-Z0-9-_. ]+$")) {
            errors.rejectValue("Contact_Last_Name", "interactions.Last_Name.pattern", "default");
        }
    }
}
