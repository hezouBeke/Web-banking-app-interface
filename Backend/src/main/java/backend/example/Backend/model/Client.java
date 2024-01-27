package backend.example.Backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="client")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String nom;
    @Column(length = 100)
    private String prenom;
    private Date naissance;
    @Column(length = 2)
    private Character sexe;
    @Column(length = 150)
    private String adresse;
    @Column(length = 50)
    private Integer telephone;
    @Column(length = 100)
    private String courriel;
    @Column(length = 100)
    private String nationalite;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Acount> acounts;


}
