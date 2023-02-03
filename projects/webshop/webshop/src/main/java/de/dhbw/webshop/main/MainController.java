package de.dhbw.webshop.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET, path = {"/", "/index.html"})
    public String index(Model model) {
        return "index";
    }
}
