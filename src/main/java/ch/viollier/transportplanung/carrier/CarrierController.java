package ch.viollier.transportplanung.carrier;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Validated
@RestController
@RequestMapping("/carriers")
public class CarrierController {
    private final CarrierService carrierService;

    @Autowired
    public CarrierController(CarrierService carrierService){
        this.carrierService = carrierService;
    }

    @GetMapping
    public ResponseEntity<List<Carrier>> getAllCarriers(){
        return ResponseEntity.ok(carrierService.getAllCarriers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrier> getCarrierById(@PathVariable Long id){
        Carrier carrier = carrierService.getCarrierById(id);
        return ResponseEntity.ok(carrier);
    }

    @PostMapping
    public ResponseEntity<Carrier> createCarrier(@Valid @RequestBody Carrier carrier){
        Carrier newCarrier  = carrierService.createCarrier(carrier);
        return ResponseEntity.ok(newCarrier);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Carrier> updateCarrier(@PathVariable Long id, @Valid @RequestBody Carrier newCarrier){
        Carrier carrier = carrierService.updateCarrier(id,newCarrier);
        return ResponseEntity.ok(carrier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCarrier(Long id){
        carrierService.deleteCarrier(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
