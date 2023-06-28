package sg.sunilsingh.rsvpmanagement_ui.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RSVP {

    private int id;
    private String fullName;
    private String email;
    private int phone;
    private Date confirmationDate;
    private String comments;
    
}
