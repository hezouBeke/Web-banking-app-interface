package backend.example.Backend.service;

import backend.example.Backend.model.Client;

import java.util.List;

public interface ClientService {
    Client creer(Client client);
    List<Client> lire();
    Client modifier(Long id,Client client);

    String supprimer(Long id);

    Client getClientById(Long clientId);

}
