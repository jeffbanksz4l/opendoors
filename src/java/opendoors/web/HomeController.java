package opendoors.web;

import java.util.HashMap;
import java.util.List;
import opendoors.objects.Clients;
import opendoors.objects.Interactions;
import opendoors.repository.ClientsDAO;
import opendoors.repository.InteractionsDAO;
import opendoors.repository.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jeffb
 */
@Controller
public class HomeController {

    @Autowired
    ClientsDAO cdao;

    @Autowired
    InteractionsDAO idao;

    @Autowired
    UsersDAO udao;

    /**
     * Mapping to View Clients
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView viewclients() {

        List<Clients> climit = cdao.getClientsLimit();

        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("climit", climit);

        List<Interactions> ilimit = idao.getInteractionsLimit();
        context.put("ilimit", ilimit);

        context.put("crowcount", cdao.getClientsCount());
        context.put("prowcount", cdao.getProspectsCount());
        context.put("xrowcount", cdao.getInactivesCount());
        context.put("irowcount", idao.getInteractionsCount());
        context.put("urowcount", udao.getUsersCount());

        return new ModelAndView("index", context);
    }
}
