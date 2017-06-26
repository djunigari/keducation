package nz.co.midori.frontend.controllers;

import nz.co.midori.frontend.configs.ApplicationAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by djunigari on 7/06/17.
 */
@Controller
public class WellcomeController {
    @Autowired
    private ApplicationAttributes appAttributes;

    @GetMapping("/")
    public String wellcomePage(Model model){
        model.addAttribute("regions", appAttributes.getRegions());
        return "/public/frontpage";
    }
}
