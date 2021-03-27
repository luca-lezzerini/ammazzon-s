package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.Prodotto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

//    @Query("SELECT p,t FROM Prodotto p JOIN p.VarianteTaglia t WHERE t.codice = 'M'")
//    List<Prodotto> cercaProdottiTagliaM();
    @Query("select p from Prodotto p where p.codice like concat ('%',:cod,'%') "
            + "or p.descrizione =:cod")
    List<Prodotto> trovaCodiceODescrizione(@Param("cod") String c);

    //     @Query("select c from Cassiera c where c.nome LIKE CONCAT('%',:cogn,'%') "
//            + "or c.cognome LIKE CONCAT('%',:cogn,'%') or c.codiceFiscale"
//            + "=:cogn")
}
