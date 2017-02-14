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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "City", "clients.City.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "State", "clients.State.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Postal_Code", "clients.Postal_Code.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Status", "clients.Status.required");

        Clients clients = (Clients) target;
        if (clients.getFirst_Name().length() > 45) {
            errors.rejectValue("First_Name", "clients.First_Name.length", "default");
        }

        if (!clients.getFirst_Name().matches("^[a-zA-Z0-9-_. ]+$")) {
            errors.rejectValue("First_Name", "clients.First_Name.pattern", "default");
        }

        if (clients.getLast_Name().length() > 45) {
            errors.rejectValue("Last_Name", "clients.Last_Name.length", "default");
        }

        if (!clients.getLast_Name().matches("^[a-zA-Z0-9-_. ]+$")) {
            errors.rejectValue("Last_Name", "clients.Last_Name.pattern", "default");
        }

        if (clients.getAddress_Line_1().length() > 45) {
            errors.rejectValue("Address_Line_1", "clients.Address_Line_1.length", "default");
        }

        if (clients.getAddress_Line_1().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("Address_Line_1", "clients.Address_Line_1.pattern", "default");
        }

        if (!clients.getAddress_Line_2().isEmpty()) {
            if (clients.getAddress_Line_2().length() > 7) {
                errors.rejectValue("Address_Line_2", "clients.Address_Line_2.length", "default");
            }
            if (!clients.getAddress_Line_2().matches("^[A-Za-z0-9]*$")) {
                errors.rejectValue("Address_Line_2", "clients.Address_Line_2.pattern", "default");
            }
        }

        if (!clients.getAddress_Line_3().isEmpty()) {
            if (clients.getAddress_Line_3().length() > 7) {
                errors.rejectValue("Address_Line_3", "clients.Address_Line_3.length", "default");
            }
        }

        if (!clients.getAddress_Line_3().isEmpty()) {
            if (!clients.getAddress_Line_3().matches("^[A-Za-z0-9]*$")) {
                errors.rejectValue("Address_Line_3", "clients.Address_Line_3.pattern", "default");
            }
        }

        if (clients.getCity().length() > 45) {
            errors.rejectValue("City", "clients.City.length", "default");
        }

        if (!clients.getCity().matches("^[a-zA-Z0-9-_. ]+$")) {
            errors.rejectValue("City", "clients.City.pattern", "default");
        }

        if (clients.getState().length() != 2) {
            errors.rejectValue("State", "clients.State.length", "default");
        }

        if (!clients.getState().matches("^[A-Za-z]*$")) {
            errors.rejectValue("State", "clients.State.pattern", "default");
        }

        if (clients.getPostal_Code().length() > 10) {
            errors.rejectValue("Postal_Code", "clients.Postal_Code.length", "default");
        }

        if (!clients.getPostal_Code().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("Postal_Code", "clients.Postal_Code.pattern", "default");
        }

        if (!clients.getEmail().isEmpty()) {
            if (!clients.getEmail().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
                errors.rejectValue("Email", "clients.Email.pattern", "default");
            }
        }

        if (!clients.getPhone_1().isEmpty()) {
            if (!clients.getPhone_1().matches("^\\(?([2-9][0-8][0-9])\\)?[-.●]?([2-9][0-9]{2})[-.●]?([0-9]{4})$")) {
                errors.rejectValue("Phone_1", "clients.Phone_1.pattern", "default");
            }
        }

        if (!clients.getPhone_2().isEmpty()) {
            if (!clients.getPhone_2().matches("^\\(?([2-9][0-8][0-9])\\)?[-.●]?([2-9][0-9]{2})[-.●]?([0-9]{4})$")) {
                errors.rejectValue("Phone_2", "clients.Phone_2.pattern", "default");
            }
        }

//        if (clients.getStatus().length() != 1) {
//            errors.rejectValue("Status", "clients.Status.length", "default");
//        }
//
//        if (!clients.getStatus().matches("^[PCI]*$")) {
//            errors.rejectValue("Status", "clients.Status.pattern", "default");
//        }
    }
}
