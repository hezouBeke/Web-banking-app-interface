package backend.example.Backend.controller;

import backend.example.Backend.model.Client;
import backend.example.Backend.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")

public class ClientController {
    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public Client create(@RequestBody Client client ){
        return  clientService.creer(client);
    }
    @GetMapping("/read")
    public List<Client> read(){
        return clientService.lire();
    }
    @PutMapping("/update/{id}")
    public  Client update(@PathVariable Long id,@RequestBody Client client){
        return clientService.modifier(id,client);
    }
    @DeleteMapping("/delete/{id}")
    public  String delete(@PathVariable Long id){
        return clientService.supprimer(id);
    }
}
