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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Contact_First_Name", "interaction.Contact_First_Name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Contact_Last_Name", "interaction.Contact_Last_Name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Contact_Type", "interaction.Contact_Type.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Conversations", "interaction.Conversations.required");

        Interactions interactions = (Interactions) target;
        if (!interactions.getDate_Of_Contact().matches("^(((((((0?[13578])|(1[02]))[\\.\\-/]?((0?[1-9])|([12]\\d)|(3[01])))|(((0?[469])|(11))[\\.\\-/]?((0?[1-9])|([12]\\d)|(30)))|((0?2)[\\.\\-/]?((0?[1-9])|(1\\d)|(2[0-8]))))[\\.\\-/]?(((19)|(20))?([\\d][\\d]))))|((0?2)[\\.\\-/]?(29)[\\.\\-/]?(((19)|(20))?(([02468][048])|([13579][26])))))$")) {
            errors.rejectValue("Date_Of_Contact", "interactions.Date_Of_Contact.pattern");
        }

        if (!interactions.getContact_First_Name().matches("^[a-zA-Z0-9-_. ]+$")) {
            errors.rejectValue("First_Name", "interactions.First_Name.pattern", "default");
        }

        if (!interactions.getContact_Last_Name().matches("^[a-zA-Z0-9-_. ]+$")) {
            errors.rejectValue("Last_Name", "interactions.Last_Name.pattern", "default");
        }
    }

}
