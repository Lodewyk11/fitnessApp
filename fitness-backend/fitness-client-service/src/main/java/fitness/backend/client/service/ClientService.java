package fitness.backend.client.service;

import fitness.backend.client.domain.Client;
import fitness.backend.client.domain.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.Specifications.*;
import static fitness.backend.client.domain.ClientRepository.Specifications.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    public List<Client> getClientsWithNameAndSurname(String firstName, String lastName) {
        return repository.findAll(
                where(firstNameIs(firstName))
                .and(lastNameIs(lastName)), orderByLastNameDesc());
    }

    public Client getClientWithEmailAddress(String email) {
        return repository.findOne(
                where(emailIs(email)));
    }

    public List<Client> getAllClients() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Client getClientByClientId(Long clientId) {
        return repository.findOne(
                where(clientIdIs(clientId)));
    }

    public Client createClient(Client client) {
        return repository.save(client);
    }
}
