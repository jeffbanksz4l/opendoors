package opendoors.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jeffb
 */
@Controller
public class HomeController {

    /**
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView viewclients() {
        return new ModelAndView("index");
    }
}
