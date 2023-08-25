package ch.viollier.transportplanung.location;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

/**
 * @author Stefan Koscica
 * @version 1.0.0
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
public abstract class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "the name cannot be empty")
    private String name;
    @NotBlank(message = "the street cannot be empty")
    private String street;
    @NotBlank(message = "the city cannot be empty")
    private String city;
    @Min(value=1000,message = "the zip must be a valid swiss zip number")
    @Max(value=9999,message = "the zip must be a valid swiss zip number")
    private Integer zip;

    public Location() {}

    public Location(String name, String street, String city, Integer zip) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) && Objects.equals(name, location.name) && Objects.equals(street, location.street) && Objects.equals(city, location.city) && Objects.equals(zip, location.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, zip);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                '}';
    }
}
