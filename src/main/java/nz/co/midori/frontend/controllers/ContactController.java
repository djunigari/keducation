package nz.co.midori.frontend.controllers;

import nz.co.midori.backend.core.services.MailSender;
import nz.co.midori.frontend.model.ContactModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by djunigari on 7/06/17.
 */
@Controller
public class ContactController {
    @Autowired
    private MailSender sender;

    @GetMapping("/contact")
    public String contactPage(){
        return "/public/contact/index";
    }

    @PostMapping("/contact")
    public String sendMessage(ContactModel contactModel){
        sender.sendMail(contactModel);
        return "redirect:/contact";
    }
}
