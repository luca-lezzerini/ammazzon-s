
package it.sirfin.ammazzonserver.repository;
import it.sirfin.ammazzonserver.model.UtenteRegistrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UtenteRegistratoRepository extends JpaRepository<UtenteRegistrato, Long> {
    
}
