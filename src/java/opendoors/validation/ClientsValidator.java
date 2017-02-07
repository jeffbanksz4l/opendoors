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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Last_Name", "clients.Last_Name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Address_Line_1", "clients.Address_Line_1.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Address_Line_2", "clients.Address_Line_2.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Address_Line_3", "clients.Address_Line_3.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "City", "clients.City.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "State", "clients.State.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Postal_Code", "clients.Postal_Code.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Email", "clients.Email.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Phone_1", "clients.Phone_1.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Phone_2", "clients.Phone_2.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Status", "clients.Status.required");

        Clients clients = (Clients) target;
        if (clients.getFirst_Name().length() > 45) {
            errors.rejectValue("First_Name", "clients.First_Name.length");
        }

        if (!clients.getFirst_Name().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("First_Name", "clients.First_Name.pattern");
        }

        if (clients.getLast_Name().length() > 45) {
            errors.rejectValue("Last_Name", "clients.Last_Name.length");
        }

        if (!clients.getLast_Name().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("Last_Name", "clients.Last_Name.pattern");
        }

        if (clients.getAddress_Line_1().length() > 70) {
            errors.rejectValue("Address_Line_1", "clients.Address_Line_1.length");
        }

        if (!clients.getAddress_Line_1().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("Address_Line_1", "clients.Address_Line_1.pattern");
        }

        if (!clients.getAddress_Line_2().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("Address_Line_2", "clients.Address_Line_2.pattern");
        }

        if (!clients.getAddress_Line_3().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("Address_Line_3", "clients.Address_Line_3.pattern");
        }
        if (clients.getCity().length() > 45) {
            errors.rejectValue("City", "clients.City.length");
        }

        if (!clients.getCity().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("City", "clients.City.pattern");
        }

        if (clients.getState().length() == 2) {
            errors.rejectValue("State", "clients.State.length");
        }

        if (!clients.getState().matches("^[A-Za-z]*$")) {
            errors.rejectValue("State", "clients.State.pattern");
        }

        if (clients.getPostal_Code().length() > 10) {
            errors.rejectValue("Postal_Code", "clients.Postal_Code.length");
        }

        if (!clients.getPostal_Code().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("Postal_Code", "clients.Postal_Code.pattern");
        }

        if (!clients.getEmail().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
            errors.rejectValue("Email", "clients.Email.pattern");
        }

        if (!clients.getPhone_1().matches("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$")) {
            errors.rejectValue("Phone_1", "clients.Phone_1.pattern");
        }

        if (!clients.getPhone_2().matches("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$")) {
            errors.rejectValue("Phone_2", "clients.Phone_2.pattern");
        }

        if (clients.getStatus().length() == 1) {
            errors.rejectValue("Status", "clients.Status.length");
        }

        if (!clients.getStatus().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("Status", "clients.Status.pattern");
        }
    }
}
