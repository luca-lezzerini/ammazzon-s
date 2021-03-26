
package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.ProdottoColore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdottoColoreRepository extends JpaRepository<ProdottoColore, Long> {
    
}
