package backend.example.Backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Acount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String numeroCompte;
    @Column(length = 100)
    private String typeCompte;
    private Double solde;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "acount", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public void deposer(double montant) {
        this.solde += montant;
    }

    public void retirer(double montant) {
        if (this.solde >= montant) {
            this.solde -= montant;
        } else {
            throw new RuntimeException("Solde insuffisant pour effectuer le retrait.");
        }
    }


}
