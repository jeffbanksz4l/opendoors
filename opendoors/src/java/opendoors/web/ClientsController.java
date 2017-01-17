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
import opendoors.repository.ClientsDAO;

/**
 *
 * @author jeffb
 */
@Controller
public class ClientsController {

    @Autowired
    ClientsDAO dao;

    /**
     *
     * @return
     */
    @RequestMapping("/clients/clientsform")
    public ModelAndView showform() {
        return new ModelAndView("clientsform", "command", new Clients());
    }

    /**
     *
     * @param clients
     * @return
     */
    @RequestMapping(value = "/clients/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("clients") Clients clients) {
        dao.save(clients);
        return new ModelAndView("redirect:/clients/viewclients");
    }

    /**
     *
     * @return
     */
    @RequestMapping("/clients/viewclients")
    public ModelAndView viewclients() {
        List<Clients> list = dao.getClientsList();
        return new ModelAndView("Viewclients", "list", list);
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/clients/editclients/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Clients clients = dao.getClientsById(id);
        return new ModelAndView("clientseditform", "command", clients);
    }

    /**
     *
     * @param clients
     * @return
     */
    @RequestMapping(value = "/clients/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("clients") Clients clients) {
        dao.update(clients);
        return new ModelAndView("redirect:/clients/viewclients");
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/clients/deleteclients/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) {
        dao.delete(id);
        return new ModelAndView("redirect:/clients/viewclients");
    }
}
