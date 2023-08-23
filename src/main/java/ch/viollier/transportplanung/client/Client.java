package ch.viollier.transportplanung.client;

import ch.viollier.transportplanung.location.Location;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 *
 */

@Entity
@DiscriminatorValue("client")
public class Client extends Location {

}
