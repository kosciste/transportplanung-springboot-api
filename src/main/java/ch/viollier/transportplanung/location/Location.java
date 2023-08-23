package ch.viollier.transportplanung.location;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * @author Stefan Koscica
 * @version 1.0.0
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype", discriminatorType = DiscriminatorType.STRING)
public abstract class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String street;
    private String city;
    private Integer zip;
    private String contact;
    private String phone;
    private String email;

    public Location() {}

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
        Location location = (Location) o;
        return Objects.equals(id, location.id) && Objects.equals(name, location.name) && Objects.equals(street, location.street) && Objects.equals(city, location.city) && Objects.equals(zip, location.zip) && Objects.equals(contact, location.contact) && Objects.equals(phone, location.phone) && Objects.equals(email, location.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, zip, contact, phone, email);
    }

    @Override
    public String toString() {
        return "Location{" +
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
