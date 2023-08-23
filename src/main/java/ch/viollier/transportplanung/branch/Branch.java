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
}
