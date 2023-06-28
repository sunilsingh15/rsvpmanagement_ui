package sg.sunilsingh.rsvpmanagement_ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.sunilsingh.rsvpmanagement_ui.service.RSVPUIService;

@Controller
@RequestMapping
public class RSVPUIController {

    @Autowired
    RSVPUIService service;

    @GetMapping
    public String indexPage() {
        return "index";
    }

    @GetMapping("/view")
    public String viewAllRSVPs(Model model) {
        model.addAttribute("rsvpList", service.retrieveAllRSVPs());
        return "view";
    }
    
}
