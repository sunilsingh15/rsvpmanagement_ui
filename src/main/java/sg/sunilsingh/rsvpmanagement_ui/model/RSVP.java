package sg.sunilsingh.rsvpmanagement_ui.model;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RSVP {

    private int id;

    @Size(min = 3, message = "Name must have at least 3 characters!")
    private String fullName;

    @NotEmpty(message = "E-mail cannot be empty!")
    @Email
    private String email;

    @Size(min = 8, max = 8, message = "Phone number must consist of 8 numbers!")
    private String phone;

    @NotNull(message = "Date cannot be empty!")
    @FutureOrPresent(message = "RSVP date cannot be in the past!")
    private Date confirmationDate;

    private String comments;

}
