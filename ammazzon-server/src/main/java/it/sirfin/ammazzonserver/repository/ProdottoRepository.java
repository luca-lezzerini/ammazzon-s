
package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.Prodotto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
    
//    @Query("SELECT p,t FROM Prodotto p JOIN p.VarianteTaglia t WHERE t.codice = 'M'")
//    List<Prodotto> cercaProdottiTagliaM();
    
}
