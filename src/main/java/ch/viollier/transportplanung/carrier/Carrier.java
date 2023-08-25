package ch.viollier.transportplanung.carrier;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

/**
 * This class represents a carrier.
 * @author Stefan Koscica
 * @version 1.0.0
 */
@Entity
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "the name cannot be empty")
    private String name;

    @NotBlank(message = "the street cannot be empty\"")
    private String street;

    @NotBlank(message = "the city cannot be empty\"")
    private String city;

    @Min(value=1000,message = "the zip must be a valid swiss zip number")
    @Max(value=9999,message = "the zip must be a valid swiss zip number")
    private Integer zip;

    @NotBlank(message = "the contact cannot be empty")
    private String contact;

    @NotBlank(message = "the phone number cannot be empty")
    private String phone;

    @NotBlank(message = "the email cannot be empty\"")
    @Email(message = "a valid email adress must be provided")
    private String email;


    public Carrier(String name, String street, String city,
                   Integer zip, String contact, String phone, String email) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.contact = contact;
        this.phone = phone;
        this.email = email;
    }

    public Carrier() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrier carrier = (Carrier) o;
        return Objects.equals(id, carrier.id) && Objects.equals(name, carrier.name) && Objects.equals(street, carrier.street) && Objects.equals(city, carrier.city) && Objects.equals(zip, carrier.zip) && Objects.equals(contact, carrier.contact) && Objects.equals(phone, carrier.phone) && Objects.equals(email, carrier.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, zip, contact, phone, email);
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", contact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
