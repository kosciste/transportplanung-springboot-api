package ch.viollier.transportplanung.carrier;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * This class represents the service layer for the carrier
 * @author Stefan Koscica
 * @version 1.0.0
 */
@Service
public class CarrierService {

    private final CarrierRepository carrierRepository;

    @Autowired
    public CarrierService(CarrierRepository carrierRepository){
        this.carrierRepository = carrierRepository;
    }

    /**
     * This method returns all available carriers
     * @return List of all carriers
     */
    public List<Carrier> getAllCarriers(){
        return carrierRepository.findAll();
    }

    /**
     * This method returns a specific carrier selected
     * by the id
     * @param id the id of the carrier
     * @return returns carrier
     * @throws EntityNotFoundException
     */
    public Carrier getCarrierById(Long id) throws EntityNotFoundException{
        Optional<Carrier> optionalCarrier = carrierRepository.findById(id);
        if(optionalCarrier.isEmpty()) throw new EntityNotFoundException("Carrier not found");
        return optionalCarrier.get();
    }

    /**
     * This method returns a List of carriers with the name
     * containing a string. If no matching carriers are
     * found, an empty list is returned.
     * @param name the name searched for
     * @return a list of matching carriers
     */
    public List<Carrier> getCarriersByName(String name){
        return carrierRepository.findByNameContaining(name);
    }

    /**
     * This method creates a carrier in the database
     * @param carrier the carrier object to be saved
     * @return the created carrier
     * @throws EntityExistsException
     */
    public Carrier createCarrier(Carrier carrier) throws EntityExistsException{
        Carrier existingCarrier = carrierRepository.findByName(carrier.getName());
        if (existingCarrier!=null) throw new EntityExistsException("Carrier already exists");
        return carrierRepository.save(carrier);
    }

    /**
     * This method gets the to be updated carrier by the id,
     * changes its attributes and saves them to the database.
     * If the carrier doesn't exist a Exception gets thrown.
     * @param id of the to be updatet carrier
     * @param newCarrier the new carrier object
     * @return carrier with updated values.
     * @throws EntityNotFoundException
     */
    public Carrier updateCarrier(Long id, Carrier newCarrier) throws EntityNotFoundException{
        Optional<Carrier> optionalCarrier = carrierRepository.findById(id);
        if(optionalCarrier.isEmpty()) throw new EntityNotFoundException("Carrier not found");
        Carrier carrier = optionalCarrier.get();
        carrier.setName(newCarrier.getName());
        carrier.setStreet(newCarrier.getStreet());
        carrier.setCity(newCarrier.getCity());
        carrier.setZip(newCarrier.getZip());
        carrier.setContact(newCarrier.getContact());
        carrier.setPhone(newCarrier.getPhone());
        carrier.setEmail(newCarrier.getEmail());
        return carrierRepository.save(carrier);

    }

    /**
     * This method deletes a defined carrier
     * @param id of the carrier to be deleted
     * @throws EntityNotFoundException
     */
    public void deleteCarrier(Long id) throws EntityNotFoundException{
        Optional<Carrier> optionalCarrier = carrierRepository.findById(id);
        if(optionalCarrier.isEmpty()) throw new EntityNotFoundException("Carrier not found");
        carrierRepository.deleteById(id);
    }


}
