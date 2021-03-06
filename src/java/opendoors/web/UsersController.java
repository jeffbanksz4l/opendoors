package opendoors.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import opendoors.objects.Users;
import opendoors.objects.Message;
import opendoors.repository.UsersDAO;
import opendoors.validation.UsersValidator;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author jeffb
 */
@Controller
public class UsersController {

    @Autowired
    UsersDAO dao;

    @Autowired
    private UsersValidator usersValidator;

    private static final Logger logger = Logger.getLogger(UsersController.class.getName());

    /**
     * Mapping for showing the Users Form
     *
     * @return
     */
    @RequestMapping("/users/usersform")
    public ModelAndView showform() {
        return new ModelAndView("usersform", "users", new Users());
    }

    /**
     * Mapping for Posting data from the Users Form - contains error messages
     *
     * @param users
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("users") @Valid Users users, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("usersform", "users", users);
        }

        int r = dao.save(users);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "User has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New user creation failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/users/viewusers");
    }

    /**
     * Mapping to View Users
     *
     * @param request
     * @return
     */
    @RequestMapping("/users/viewusers")
    public ModelAndView viewusers(HttpServletRequest request) {
        return this.viewusers(1, request);
    }

    /**
     * Mapping the View Users with pagination - contains error messages
     *
     * @param pageid
     * @param request
     * @return
     */
    @RequestMapping("/users/viewusers/{pageid}")
    public ModelAndView viewusers(@PathVariable int pageid, HttpServletRequest request) {
        int total = 10;
        int start = 1;

        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<Users> list = dao.getUsersByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = dao.getUsersCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewusers", context);
    }

    /**
     * Mapping to Edit Users based on Username
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/users/editusers/{name}")
    public ModelAndView edit(@PathVariable String name) {
        Users users = dao.getUsersByName(name);
        return new ModelAndView("userseditform", "users", users);
    }

    /**
     * Mapping for Posting Edited data from the Users Form - contains error
     * messages
     *
     * @param users
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/users/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("users") @Valid Users users, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("userseditform", "users", users);
        }

        int r = dao.update(users);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "User has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit user failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/users/viewusers");
    }

    /**
     * Initiate User Validator
     *
     * @param webDataBinder
     */
    @InitBinder("users")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(usersValidator);
    }

    /**
     * Get User Validator
     *
     * @return
     */
    public UsersValidator getUsersValidator() {
        return usersValidator;
    }

    /**
     * Set User Validator
     *
     * @param usersValidator
     */
    public void setUsersValidator(UsersValidator usersValidator) {
        this.usersValidator = usersValidator;
    }
}
