package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.ColoreTaglia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ColoreTagliaRepository extends JpaRepository<ColoreTaglia, Long> {

    @Query("SELECT ct FROM ColoreTaglia ct WHERE "
            + "ct.prodottoColore.prodotto.descrizione = 'CAPPELLO' "
            + "and ct.prodottoColore.varianteColore.descrizione  = 'rosso'")
    List<ColoreTaglia> taglieCappelloRosso();
    
    /**
     * Trova tutte le taglie associate a un prodotto colore dato un prodottoColore id
     * @param id
     * @return 
     */
    @Query("SELECT ct FROM ColoreTaglia ct WHERE "
            + "ct.prodottoColore.id = :id ")
    List<ColoreTaglia> taglieProdottoColore(@Param("id") Long id);
    
    @Query("SELECT ct FROM ColoreTaglia ct WHERE "
            + "ct.prodottoColore.id != :id ")
    List<ColoreTaglia> notTaglieProdottoColore(@Param("id") Long id);
    

    
}
