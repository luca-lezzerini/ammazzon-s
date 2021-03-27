package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.ColoreTaglia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColoreTagliaRepository extends JpaRepository<ColoreTaglia, Long> {

    @Query("SELECT ct FROM ColoreTaglia ct WHERE "
            + "ct.prodottoColore.prodotto.descrizione = 'CAPPELLO' "
            + "and ct.prodottoColore.varianteColore.descrizione  = 'rosso'")
    List<ColoreTaglia> taglieCappelloRosso();
}
