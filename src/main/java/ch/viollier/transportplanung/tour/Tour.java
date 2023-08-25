package ch.viollier.transportplanung.tour;

import ch.viollier.transportplanung.branch.Branch;
import ch.viollier.transportplanung.carrier.Carrier;
import ch.viollier.transportplanung.location.Location;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "cannot be empty")
    @ManyToOne
    @JoinColumn(name="start_location_id")
    private Location startLocation;

    @NotNull(message = "cannot be empty")
    @ManyToOne
    @JoinColumn(name="end_location_id")
    private Location endLocation;

    @NotNull(message = "cannot be empty")
    @ManyToOne
    @JoinColumn(name="branch_id")
    private Branch responsibleBranch;

    @NotNull(message = "cannot be empty")
    @ManyToOne
    @JoinColumn(name="carrier_id")
    private Carrier carrier;

    private Weekday startDay;

    private Weekday endDay;

    private Time startTime;

    private Time endTime;
    

}
