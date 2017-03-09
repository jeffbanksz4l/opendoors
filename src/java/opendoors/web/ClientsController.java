package opendoors.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import opendoors.objects.Clients;
import opendoors.objects.Message;
import opendoors.repository.ClientsDAO;
import opendoors.validation.ClientsValidator;
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
public class ClientsController {

    @Autowired
    ClientsDAO dao;

    @Autowired
    private ClientsValidator clientsValidator;

    private static final Logger logger = Logger.getLogger(ClientsController.class.getName());

    /**
     * Mapping for showing the Clients Form
     *
     * @return
     */
    @RequestMapping("/clients/clientsform")
    public ModelAndView showform() {
        return new ModelAndView("clientsform", "clients", new Clients());
    }

    /**
     ** Mapping for Posting data from the Clients Form - contains error
     * messages
     *
     * @param clients
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/clients/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("clients") @Valid Clients clients, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {

            logger.info(result.getFieldErrors().toString());

            return new ModelAndView("clientsform", "clients", clients);
        }

        int r = dao.save(clients);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Client/Prospect has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New client/prospect creation failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/clients/viewclients");
    }

    /**
     * Mapping to View Clients
     *
     * @param request
     * @return
     */
    @RequestMapping("/clients/viewclients")
    public ModelAndView viewclients(HttpServletRequest request) {
        return this.viewclients(1, request);
    }

    /**
     * Mapping the Convert the status of existing Clients/Prospects to Inactive
     * - contains error messages
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/clients/convert/{id}")
    public ModelAndView convert(@PathVariable int id, HttpServletRequest request) {

        int r = dao.convert(id);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Status has been successfully changed");
        } else {
            msg = new Message(Message.Level.ERROR, "Status was not changed");
        }

        request.getSession().setAttribute("message", msg);
        return new ModelAndView("redirect:/clients/viewclients");
    }

    /**
     * Mapping the View Clients with pagination - contains error messages
     *
     * @param pageid
     * @param request
     * @return
     */
    @RequestMapping("/clients/viewclients/{pageid}")
    public ModelAndView viewclients(@PathVariable int pageid, HttpServletRequest request) {
        int total = 10;
        int start = 1;
        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<Clients> list = dao.getClientsByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = dao.getClientsCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewclients", context);
    }

    /**
     * Mapping to Edit Clients based on Clients ID
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/clients/editclients/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Clients clients = dao.getClientsById(id);
        return new ModelAndView("clientseditform", "clients", clients);
    }

    /**
     * Mapping to Display Clients based on Clients ID
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/clients/clientdisplay/{id}", method = RequestMethod.GET)
    public ModelAndView display(@PathVariable("id") int id) {

        Clients cdisplay = dao.getClientsById(id);

        return new ModelAndView("clientdisplay", "id", cdisplay);
    }

    /**
     * Mapping for Posting Edited data from the Clients Form - contains error
     * messages
     *
     * @param clients
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/clients/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("clients") @Valid Clients clients, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return new ModelAndView("clientseditform", "clients", clients);
        }

        int r = dao.update(clients);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Client/Prospect has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit client/prospect failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/clients/viewclients");
    }

    /**
     * Initiate Clients Validator
     *
     * @param webDataBinder
     */
    @InitBinder("clients")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(clientsValidator);
    }

    /**
     * Get Clients Validator
     *
     * @return
     */
    public ClientsValidator getClientsValidator() {
        return clientsValidator;
    }

    /**
     * Set Clients Validator
     *
     * @param clientsValidator
     */
    public void setClientsValidator(ClientsValidator clientsValidator) {
        this.clientsValidator = clientsValidator;
    }
}
