package sg.sunilsingh.rsvpmanagement_ui.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.sunilsingh.rsvpmanagement_ui.model.RSVP;

@RestController
@RequestMapping("/api")
public class RSVPAPIController {

    @Autowired
    JdbcTemplate template;

    private final String getAllRSVPs = "select * from rsvps";

    @GetMapping("/rsvps")
    public List<RSVP> allRSVPs() {
        return template.query(getAllRSVPs, BeanPropertyRowMapper.newInstance(RSVP.class));
    }
    
}
