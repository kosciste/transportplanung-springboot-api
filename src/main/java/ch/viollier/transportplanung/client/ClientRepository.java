package ch.viollier.transportplanung.client;

import ch.viollier.transportplanung.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByNameContaining(String name);
    Client findByName(String name);
}
