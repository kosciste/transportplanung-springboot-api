package ch.viollier.transportplanung.holiday;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {
    List<Holiday> findByNameContaining(String name);

    Holiday findByName(String name);
}
