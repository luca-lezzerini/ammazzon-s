package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.ProdottoColore;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoColoreRepository extends JpaRepository<ProdottoColore, Long> {

    @Query("SELECT pc FROM ProdottoColore pc WHERE pc.prodotto.descrizione = 'PANTALONE'"
            + "and pc.varianteColore.descrizione = 'giallo'")
    List<ProdottoColore> pantaloniGialli();

    @Query("SELECT pc FROM ProdottoColore pc WHERE pc.prodotto.descrizione = 'PANTALONE'"
            + "and pc.varianteColore.descrizione = 'blu'")
    List<ProdottoColore> pantaloniBlu();

    @Query("SELECT pc FROM ProdottoColore pc WHERE pc.prodotto.descrizione = 'CAPPELLO'"
            + "and pc.varianteColore.descrizione = 'rosso'")
    List<ProdottoColore> CappelliRossi();

    /**
     * Trova tutti i prodottoColore associati al prodotto con id dato in inpt
     *
     * @param id
     * @return List<ProdottoColore>
     */
    @Query("SELECT pc FROM ProdottoColore pc WHERE pc.prodotto.id = :p")
    List<ProdottoColore> coloriAssociatiProdotto(@Param("p") Long id);

    //Query non funzionante per il momento
    @Query("SELECT pc FROM ProdottoColore pc WHERE pc.prodotto.id = :p")
    List<ProdottoColore> selezionaProdotto(@Param("p") Long id);

    //Prova così
    @Query("SELECT pc FROM ProdottoColore pc WHERE pc.prodotto.id = :p")
    List<ProdottoColore> selezionaProdotto1(@Param("p") Long id);

    @Query("SELECT pc FROM ProdottoColore pc"
            + " JOIN pc.varianteColore vc"
            + " JOIN pc.prodotto p"
            + " WHERE p.id = :prodId"
            + " AND vc.id = :colId")
    ProdottoColore trovaProdottoColore(@Param("prodId") Long idProdotto, @Param("colId") Long idColore);

    /**
     * trova tutti i prodotti di un dato colore
     *
     * @param nomeColore
     * @param nomeProdotto
     * @return
     */
    @Query("SELECT pc FROM ProdottoColore pc WHERE pc.prodotto.descrizione = (?2)"
            + "and pc.varianteColore.descrizione = (?1)")
    List<ProdottoColore> prodottoColore(String nomeColore, String nomeProdotto);

    @Modifying
    @Query("update ProdottoColore pc set pc.prodotto.id = null where pc.prodotto.id =:id")
    int disassociaColoreProdotto(@Param("id") Long id);

}
