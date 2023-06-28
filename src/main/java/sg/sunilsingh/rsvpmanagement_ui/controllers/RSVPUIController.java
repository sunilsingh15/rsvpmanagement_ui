package sg.sunilsingh.rsvpmanagement_ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.sunilsingh.rsvpmanagement_ui.model.RSVP;
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

    @GetMapping("/create")
    public String createNewRSVPForm(Model model) {
        model.addAttribute("newRSVP", new RSVP());
        return "create";
    }

    @PostMapping("/create")
    public String createNewRSVP(@Valid @ModelAttribute("newRSVP") RSVP rsvpToAdd, BindingResult result) {

        if (result.hasErrors()) {
            return "create";
        }

        if (service.addNewRSVP(rsvpToAdd)) {
            return "created";
        }

        return "error";
    }

    
}
