package ch.viollier.transportplanung.carrier;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carriers")
public class CarrierController {
    private final CarrierService carrierService;

    @Autowired
    public CarrierController(CarrierService carrierService){
        this.carrierService = carrierService;
    }

   //TODO: defined methods

    @GetMapping
    public List<Carrier> getAllCarriers(){
        return carrierService.getAllCarriers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrier> getCarrierById(@PathVariable Long id){
        try{
            Carrier carrier = carrierService.getCarrierById(id);
            return ResponseEntity.ok(carrier);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Carrier> createCarrier(@RequestBody Carrier carrier){
        try{
            carrierService.createCarrier(carrier);
            return ResponseEntity.ok(carrier);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }







}
