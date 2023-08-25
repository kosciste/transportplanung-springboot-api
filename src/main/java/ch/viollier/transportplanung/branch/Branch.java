package ch.viollier.transportplanung.branch;

import ch.viollier.transportplanung.location.Location;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 *
 */
@Entity
@DiscriminatorValue("branch")
public class Branch extends Location {

    public Branch(){
        super();
    }

    public Branch(String name, String street, String city, Integer zip ) {
        super(name,street,city,zip);
    }

    @Override
    public String toString() {
        return "Branch{} " + super.toString();
    }
}
