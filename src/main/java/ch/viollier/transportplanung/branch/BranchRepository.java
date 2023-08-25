package ch.viollier.transportplanung.branch;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch,Long> {

    List<Branch> findByNameContaining(String name);
    Branch findByName(String name);
}
