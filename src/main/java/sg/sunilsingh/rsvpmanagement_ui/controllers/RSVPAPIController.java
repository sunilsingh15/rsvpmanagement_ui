package sg.sunilsingh.rsvpmanagement_ui.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.sunilsingh.rsvpmanagement_ui.model.RSVP;

@RestController
@RequestMapping("/api")
public class RSVPAPIController {

    @Autowired
    JdbcTemplate template;

    private final String getAllRSVPs = "select * from rsvps";
    private final String insertRSVP = "insert into rsvps (full_name, email, phone, confirmation_date, comments) values (?, ?, ?, ?, ?)";

    @GetMapping("/rsvps")
    public List<RSVP> allRSVPs() {
        return template.query(getAllRSVPs, BeanPropertyRowMapper.newInstance(RSVP.class));
    }

    @PostMapping("/new")
    public Boolean createRSVP(@RequestBody RSVP rsvp) {
        if (template.update(insertRSVP, rsvp.getFullName(), rsvp.getEmail(), rsvp.getPhone(), rsvp.getConfirmationDate(), rsvp.getComments()) == 1) {
            return true;
        } else {
            return false;
        }
    }

}
