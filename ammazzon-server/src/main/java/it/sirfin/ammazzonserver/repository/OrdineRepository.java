
package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Long> {
    
}
