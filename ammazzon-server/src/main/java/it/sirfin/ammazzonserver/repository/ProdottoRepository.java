
package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
    
}
