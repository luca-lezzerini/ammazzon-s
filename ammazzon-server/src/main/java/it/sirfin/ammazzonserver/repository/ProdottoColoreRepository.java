
package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.ProdottoColore;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdottoColoreRepository extends JpaRepository<ProdottoColore, Long> {
    
//    @Query("SELECT p FROM Prodotto p WHERE p.prodottoColore.varianteColore = 'giallo'")
//    List<ProdottoColore> ProdottiGialli();
}
