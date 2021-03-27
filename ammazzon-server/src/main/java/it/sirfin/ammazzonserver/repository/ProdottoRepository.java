package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.Prodotto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {


    @Query("select p from Prodotto p where p.codice like concat ('%',:cod,'%') "
            + "or p.descrizione =:cod")
    List<Prodotto> trovaCodiceODescrizione(@Param("cod") String c);
}
