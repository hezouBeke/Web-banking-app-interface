package backend.example.Backend.controller;

import backend.example.Backend.model.Acount;
import backend.example.Backend.model.Client;
import backend.example.Backend.service.AcountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/compte")
public class AcountController {
    private final AcountService acountService;

    public AcountController(AcountService acountService) {
        this.acountService = acountService;
    }

    @PostMapping("/create/{client_id}")
    public Acount create(@RequestBody Acount acount, @PathVariable Long client_id) {
        return acountService.creer(client_id, acount);
    }

    @GetMapping("/read")
    public List<Acount> read() {
        return acountService.lire();
    }

    @PutMapping("/update/{id}")
    public Client update(@PathVariable Long id, @RequestBody Acount acount) {
        return acountService.modifier(id, acount).getClient();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return acountService.supprimer(id);
    }
}


