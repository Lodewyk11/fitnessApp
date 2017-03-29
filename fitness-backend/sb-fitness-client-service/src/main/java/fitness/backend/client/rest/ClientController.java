package fitness.backend.client.rest;

import fitness.backend.client.domain.Client;
import fitness.backend.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping("/{firstName}/{lastName}")
    public List<Client> getOnFirstNameAndLastName(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName) {
        return clientService.getClientsWithNameAndSurname(firstName, lastName);
    }

}
