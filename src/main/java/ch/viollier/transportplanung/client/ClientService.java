package ch.viollier.transportplanung.client;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    /**
     * This method returns a specific client selected
     * by the id
     * @param id the id of the client
     * @return returns client
     * @throws EntityNotFoundException
     */
    public Client getClientById(Long id) throws EntityNotFoundException{
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isEmpty()) throw new EntityNotFoundException("Client not found");
        return optionalClient.get();
    }

    /**
     * This method returns a List of clients with the name
     * containing a string. If no matching clients are
     * found, an empty list is returned.
     * @param name the name searched for
     * @return a list of matching clients
     */
    public List<Client> getClientsByName(String name){
        return clientRepository.findByNameContaining(name);
    }

    /**
     * This method creates a client in the database
     * @param client the client object to be saved
     * @return the created client
     * @throws EntityExistsException
     */
    public Client createClient(Client client) throws EntityExistsException{
        Client existingClient = clientRepository.findByName(client.getName());
        if (existingClient!=null) throw new EntityExistsException("Client already exists");
        return clientRepository.save(client);
    }

    /**
     * This method gets the to be updated client by the id,
     * changes its attributes and saves them to the database.
     * If the client doesn't exist an exception gets thrown.
     * @param id of the to be updated client
     * @param newClient the new client object
     * @return client with updated values.
     * @throws EntityNotFoundException
     */
    public Client updateClient(Long id, Client newClient) throws EntityNotFoundException{
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isEmpty()) throw new EntityNotFoundException("Client not found");
        Client client = optionalClient.get();
        client.setName(newClient.getName());
        client.setStreet(newClient.getStreet());
        client.setCity(newClient.getCity());
        client.setZip(newClient.getZip());
        return clientRepository.save(client);

    }

    /**
     * This method deletes a defined client
     * @param id of the client to be deleted
     * @throws EntityNotFoundException
     */
    public void deleteClient(Long id) throws EntityNotFoundException{
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isEmpty()) throw new EntityNotFoundException("Client not found");
        clientRepository.deleteById(id);
    }
}
