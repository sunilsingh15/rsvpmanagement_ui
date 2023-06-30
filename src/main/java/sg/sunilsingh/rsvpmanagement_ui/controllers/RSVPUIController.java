package sg.sunilsingh.rsvpmanagement_ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/search")
    public String showSearchPage() {
        return "search";
    }

    @GetMapping("/searchbyid")
    public String searchByID(@RequestParam int searchID) {
        if (service.checkIfRSVPExists(searchID)) {
            return "redirect:/view/" + searchID;
        } else {
            return "search";
        }
    }

    @GetMapping ("/view/{id}")
    public String viewRSVP(@PathVariable("id") int id, Model model) {
        model.addAttribute("rsvp", service.getRSVPByID(id));
        return "viewRSVP";
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

    @GetMapping("/update")
    public String showUpdateSearchPage() {
        return "update";
    }

    @GetMapping("/updatersvp")
    public String searchByIDtoUpdate(@RequestParam int searchID) {
        if (service.checkIfRSVPExists(searchID)) {
            return "redirect:/update/" + searchID;
        } else {
            return "update";
        }
    }

    @GetMapping("/update/{id}")
    public String updateRSVP(@PathVariable("id") int id, Model model) {
        model.addAttribute("rsvp", service.getRSVPByID(id));
        return "updateRSVP";
    }

    @PostMapping("/update")
    public String updateRSVPtoDB(@ModelAttribute("rsvp") RSVP rsvpToUpdate) {
        System.out.println(rsvpToUpdate);
        if (service.updateRSVP(rsvpToUpdate)) {
            return "updated";
        }
        return "error";
    }

    @GetMapping("/delete")
    public String showDeleteSearchPage() {
        return "delete";
    }

    @GetMapping("/deletersvp")
    public String searchByIDtoDelete(@RequestParam int searchID) {
        if (service.checkIfRSVPExists(searchID)) {
            return "redirect:/delete/" + searchID;
        } else {
            return "delete";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteRSVP(@PathVariable("id") int id) {
        if (service.deleteRSVPbyID(id)) {
            return "deleted";
        } else {
            return "error";
        }
    }
    
}
