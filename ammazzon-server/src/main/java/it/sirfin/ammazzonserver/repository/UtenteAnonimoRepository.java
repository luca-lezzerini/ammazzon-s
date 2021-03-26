
package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.UtenteAnonimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UtenteAnonimoRepository extends JpaRepository<UtenteAnonimo, Long> {
    
}
