package backend.example.Backend.repository;

import backend.example.Backend.model.Acount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AcountRepository extends JpaRepository<Acount,Long> {


    List<Acount> findByClientId(Long clientId);

    Optional<Acount> findByNumeroCompte(String numeroCompte);

}
