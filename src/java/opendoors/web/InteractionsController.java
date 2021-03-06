package opendoors.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import opendoors.objects.Interactions;
import opendoors.objects.Clients;
import opendoors.objects.Message;
import opendoors.repository.InteractionsDAO;
import opendoors.repository.ClientsDAO;
import opendoors.validation.InteractionsValidator;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author jeffb
 */
@Controller
public class InteractionsController {

    @Autowired
    InteractionsDAO dao;

    @Autowired
    ClientsDAO adao = new ClientsDAO();

    @Autowired
    private InteractionsValidator interactionsValidator;

    private static final Logger logger = Logger.getLogger(InteractionsController.class.getName());

    /**
     * Mapping for showing the Interaction Form
     *
     * @return
     */
    @RequestMapping("/interactions/interactionsform")
    public ModelAndView showform() {
        Interactions interactions = new Interactions();
        interactions.setClient(dao.getClientInteractMap());

        return new ModelAndView("interactionsform", "interactions", interactions);
    }

    /**
     * Mapping for showing the Users Form with Client ID
     *
     * @param id
     * @return
     */
    @RequestMapping("/interactions/interactionsform/{id}")
    public ModelAndView showformWithClients(@PathVariable int id) {
        Clients clients = adao.getClientsById(id);

        Interactions interactions = new Interactions();
//        interactions.setInteractionsID(id);
        interactions.setClients(clients);
        interactions.setClients_ID(id);

        interactions.setClient(dao.getClientInteractMap());

        return new ModelAndView("interactionsform", "interactions", interactions);
    }

    /**
     * Mapping for Posting data from the Interaction Form - contains error
     * messages
     *
     * @param interactions
     * @param request
     * @return
     */
    @RequestMapping(value = "/interactions/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("interactions") Interactions interactions, HttpServletRequest request) {
        int r = dao.save(interactions);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully created");
        } else {
            msg = new Message(Message.Level.ERROR, "New interaction creation failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    /**
     * Mapping to View Interactions
     *
     * @param request
     * @return
     */
    @RequestMapping("/interactions/viewinteractions")
    public ModelAndView viewinteractions(HttpServletRequest request) {

        return this.viewinteractions(1, request);
    }

    /**
     * Mapping the View Interactions with pagination - contains error messages
     *
     * @param pageid
     * @param request
     * @return
     */
    @RequestMapping("/interactions/viewinteractions/{pageid}")
    public ModelAndView viewinteractions(@PathVariable int pageid, HttpServletRequest request) {
        int total = 10;
        int start = 1;
        if (pageid != 1) {
            start = (pageid - 1) * total + 1;
        }

        List<Interactions> list = dao.getInteractionsByPage(start, total);

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);

        int count = dao.getInteractionsCount();
        context.put("pages", Math.ceil((float) count / (float) total));

        context.put("page", pageid);

        Message msg = (Message) request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }

        return new ModelAndView("viewinteractions", context);
    }

    /**
     * Mapping to Edit Interactions based on Interaction ID
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/interactions/editinteractions/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Interactions interactions = dao.getInteractionsById(id);

        interactions.setClient(dao.getClientInteractMap());

        return new ModelAndView("interactionseditform", "interactions", interactions);
    }

    /**
     * Mapping for Posting Edited data from the Users Form - contains error
     * messages
     *
     * @param interactions
     * @param request
     * @return
     */
    @RequestMapping(value = "/interactions/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("interactions") Interactions interactions, HttpServletRequest request) {
        int r = dao.update(interactions);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully saved");
        } else {
            msg = new Message(Message.Level.ERROR, "Edit interactions failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    /**
     * Mapping for Deleting data an Interaction - contains error messages
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/interactions/deleteinteractions/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request) {
        int r = dao.delete(id);

        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully deleted");
        } else {
            msg = new Message(Message.Level.ERROR, "Delete interaction failed");
        }

        request.getSession().setAttribute("message", msg);

        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    /**
     * Initiate Interaction Validator
     *
     * @param webDataBinder
     */
    @InitBinder("interactions")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(interactionsValidator);
    }

    /**
     * Get Interaction Validator
     *
     * @return
     */
    public InteractionsValidator getInteractionsValidator() {
        return interactionsValidator;
    }

    /**
     * Set Interaction Validator
     *
     * @param interactionsValidator
     */
    public void setInteractionsValidator(InteractionsValidator interactionsValidator) {
        this.interactionsValidator = interactionsValidator;
    }
}
