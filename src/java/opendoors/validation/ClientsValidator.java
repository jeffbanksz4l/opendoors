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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Customer", "clients.Customer.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Address_Line_1", "clients.Address_Line_1.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "City", "clients.City.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "State", "clients.State.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Postal_Code", "clients.Postal_Code.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Status", "clients.Status.required");

        Clients clients = (Clients) target;
        if (clients.getCustomer().length() > 45) {
            errors.rejectValue("Customer", "clients.Customer.length", "default");
        }

        if (!clients.getCustomer().matches("^[a-zA-Z\\ \\'&-.]*$")) {
            errors.rejectValue("Customer", "clients.Customer.pattern", "default");
        }

        if (clients.getAddress_Line_1().length() > 45) {
            errors.rejectValue("Address_Line_1", "clients.Address_Line_1.length", "default");
        }

        if (clients.getAddress_Line_1().matches("^[a-zA-Z0-9_.,\'#]+$")) {
            errors.rejectValue("Address_Line_1", "clients.Address_Line_1.pattern", "default");
        }

        if (!clients.getAddress_Line_2().isEmpty()) {
            if (clients.getAddress_Line_2().length() > 70) {
                errors.rejectValue("Address_Line_2", "clients.Address_Line_2.length", "default");
            }
            if (!clients.getAddress_Line_2().matches("^[A-Za-z0-9 _.,!\"'/$#]*$")) {
                errors.rejectValue("Address_Line_2", "clients.Address_Line_2.pattern", "default");
            }
        }

        if (clients.getCity().length() > 45) {
            errors.rejectValue("City", "clients.City.length", "default");
        }

        if (!clients.getCity().matches("^[a-zA-Z0-9-_. ]+$")) {
            errors.rejectValue("City", "clients.City.pattern", "default");
        }

        if (!clients.getState().matches("^[A-Za-z- ]*$")) {
            errors.rejectValue("State", "clients.State.pattern", "default");
        }

        if (clients.getPostal_Code().length() > 10) {
            errors.rejectValue("Postal_Code", "clients.Postal_Code.length", "default");
        }

        if (!clients.getPostal_Code().matches("^[0-9]{5}(?:-[0-9]{4})?$")) {
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
    }
}
