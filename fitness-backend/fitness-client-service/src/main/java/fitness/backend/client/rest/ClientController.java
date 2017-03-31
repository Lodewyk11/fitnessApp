package fitness.backend.client.rest;

import fitness.backend.client.domain.Client;
import fitness.backend.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/{firstName}/{lastName}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Client>> getOnFirstNameAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return ResponseEntity.ok(clientService.getClientsWithNameAndSurname(firstName, lastName));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Client>> getAllCiients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Client> getClientByClientId(@PathVariable("clientId") Long clientId) {
        return ResponseEntity.ok(clientService.getClientByClientId(clientId));
    }


    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Long> createClient(@RequestBody Client client) {
        Client savedClient;
        try {
            savedClient = clientService.createClient(client);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Couldn't save client: " + e.getMessage());
            return new ResponseEntity("Couldn't save client:" + e.getMessage(), HttpStatus.BAD_REQUEST);

        }
        return ResponseEntity.ok(savedClient.getId());
    }

}
