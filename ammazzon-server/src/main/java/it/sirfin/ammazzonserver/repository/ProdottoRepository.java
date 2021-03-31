package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.Prodotto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

    /**
     * Trova e pagina prodotti per codice totale o descrizione like
     * @param c
     * @param pageable
     * @return Page
     */
    @Query("select p from Prodotto p where p.descrizione like concat ('%',:cod,'%') "
            + "or p.codice =:cod")
    Page trovaCodiceODescrizionePageable(@Param("cod") String c, Pageable pageable);

    @Query("select p from Prodotto p where p.codice like concat ('%',:cod,'%') "
            + "or p.descrizione =:cod")
    List<Prodotto> trovaCodiceODescrizione(@Param("cod") String c);
    

    @Query("select p from Prodotto p where p.descrizione like concat ('%',:cod,'%') "
            + "or p.codice =:cod")
    List<Prodotto> trovaPerCodiceODescrizioneLike(@Param("cod") String c);

    @Modifying
    @Query("update Prodotto p set p.codice = :codice, p.descrizione =:descrizione, p.prezzo = :prezzo where p.id =:id")
    void modificaProdotto(@Param("codice") String codice, @Param("descrizione") String descrizione, @Param("prezzo") Double prezzo, @Param("id") Long id);

    List<Prodotto> findByCodiceContainsOrDescrizioneContainsOrPrezzoContains(String codice, String descrizione, Double prezzo);
 
}
