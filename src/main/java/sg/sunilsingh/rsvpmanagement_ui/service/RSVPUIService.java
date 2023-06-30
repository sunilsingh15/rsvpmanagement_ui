package sg.sunilsingh.rsvpmanagement_ui.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sg.sunilsingh.rsvpmanagement_ui.model.RSVP;

@Service
public class RSVPUIService {

    RestTemplate template = new RestTemplate();

    private final String apiURL = "http://localhost:8080/api";

    public List<RSVP> retrieveAllRSVPs() {
        ResponseEntity<List<RSVP>> response = template.exchange(
                apiURL + "/rsvps",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<RSVP>>() {
                });

        return response.getBody();
    }

    public Boolean addNewRSVP(RSVP rsvpToAdd) {
        return template.postForEntity(apiURL + "/new", rsvpToAdd, Boolean.class).getBody();
    }

    public Boolean checkIfRSVPExists(int id) {
        return template.getForEntity(apiURL + "/search/" + id, Boolean.class).getBody();
    }

    public RSVP getRSVPByID(int id) {
        return template.getForObject(apiURL + "/rsvp/" + id, RSVP.class);
    }

    public Boolean updateRSVP(RSVP rsvpToUpdate) {
        return template.postForEntity(apiURL + "/update", rsvpToUpdate, Boolean.class).getBody();
    }

}
