package ch.viollier.transportplanung.client;

import ch.viollier.transportplanung.carrier.Carrier;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.ref.Cleaner;
import java.util.List;

@Validated
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        Client client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client newClient){
        Client client  = clientService.createClient(newClient);
        return ResponseEntity.ok(client);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @Valid @RequestBody Client newClient){
        Client client = clientService.updateClient(id,newClient);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClient(Long id){
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
    //TODO: Implement Controller
}
