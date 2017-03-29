package fitness.backend.client.service;

import fitness.backend.client.domain.Client;
import fitness.backend.client.domain.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.Specifications.*;
import static fitness.backend.client.domain.ClientRepository.Specifications.*;

import java.util.List;

public class ClientService {

    @Autowired
    ClientRepository repository;

    public List<Client> getClientsWithNameAndSurname(String firstName, String lastName) {
        return repository.findAll(
                where(firstNameIs(firstName))
                .and(lastNameIs(lastName)));
    }
}
