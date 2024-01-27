package backend.example.Backend.service;

import backend.example.Backend.model.Client;
import backend.example.Backend.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;

    @Override
    public Client creer(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> lire() {
        return clientRepository.findAll();
    }

    @Override
    public Client modifier(Long id, Client client) {
        return clientRepository.findById(id)
                .map(c->{
                    c.setAdresse(client.getAdresse());
                    c.setNom(client.getNom());
                    c.setPrenom(client.getPrenom());
                    c.setNaissance(client.getNaissance());
                    c.setSexe(client.getSexe());
                    c.setCourriel(client.getCourriel());
                    c.setNationalite(client.getNationalite());
                    c.setTelephone(client.getTelephone());
                    return clientRepository.save(c);

                }).orElseThrow(()->new RuntimeException("Client non trouvé!"));
    }

    @Override
    public String supprimer(Long id) {
        clientRepository.deleteById(id);
        return "Client supprimé avec succes!";
    }

    public Client getClientById(Long clientId) {
        return null;
    }


}
