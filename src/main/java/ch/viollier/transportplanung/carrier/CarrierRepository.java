package ch.viollier.transportplanung.carrier;

import ch.viollier.transportplanung.carrier.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarrierRepository extends JpaRepository<Carrier, Long> {
    List<Carrier> findByNameContaining(String name);
    Carrier findByName(String name);
}
