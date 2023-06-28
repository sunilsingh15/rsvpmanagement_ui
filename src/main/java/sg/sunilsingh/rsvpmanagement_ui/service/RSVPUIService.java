package sg.sunilsingh.rsvpmanagement_ui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sg.sunilsingh.rsvpmanagement_ui.model.RSVP;

@Service
public class RSVPUIService {

    @Autowired
    RestTemplate template;

    private final String apiURL = "http://localhost:8080/api";

    public List<RSVP> retrieveAllRSVPs() {
        ResponseEntity<List<RSVP>> response = template.exchange(
                apiURL + "/view",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<RSVP>>() {
                });

                return response.getBody();
    }

}
