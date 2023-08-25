package ch.viollier.transportplanung.client;

import ch.viollier.transportplanung.location.Location;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

/**
 *
 */

@Entity
@DiscriminatorValue("client")
public class Client extends Location {

    @NotBlank(message = "the contact cannot be empty")
    private String contact;

    @NotBlank(message = "the phone number cannot be empty")
    private String phone;

    @NotBlank(message = "the mail cannot be empty")
    @Email(message = "a valid mail must be provided")
    private String email;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client(){
        super();
    }

    public Client(String name, String street, String city, Integer zip, String contact, String phone, String email){
        super(name, street, city, zip);
        this.contact = contact;
        this.phone = phone;
        this.email = email;
    }




}
