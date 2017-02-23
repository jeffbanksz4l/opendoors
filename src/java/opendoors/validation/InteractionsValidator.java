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
//        if (!interactions.getDate_Of_Contact().matches("^(((\\d{4})(-)(0[13578]|10|12)(-)(0[1-9]|[12][0-9]|3[01]))|((\\d{4})(-)(0[469]|1‌​1)(-)([0][1-9]|[12][0-9]|30))|((\\d{4})(-)(02)(-)(0[1-9]|1[0-9]|2[0-8]))|(([02468]‌​[048]00)(-)(02)(-)(29))|(([13579][26]00)(-)(02)(-)(29))|(([0-9][0-9][0][48])(-)(0‌​2)(-)(29))|(([0-9][0-9][2468][048])(-)(02)(-)(29))|(([0-9][0-9][13579][26])(-)(02‌​)(-)(29)))(\\s([0-1][0-9]|2[0-4]):([0-5][0-9]):([0-5][0-9]))$")) {
//            errors.rejectValue("Date_Of_Contact", "interactions.Date_Of_Contact.pattern");
//        }

        if (!interactions.getContact_First_Name().matches("^[a-zA-Z0-9-_. ]+$")) {
            errors.rejectValue("First_Name", "interactions.First_Name.pattern", "default");
        }

        if (!interactions.getContact_Last_Name().matches("^[a-zA-Z0-9-_. ]+$")) {
            errors.rejectValue("Last_Name", "interactions.Last_Name.pattern", "default");
        }
    }

}
