package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.Prodotto;
import it.sirfin.ammazzonserver.model.ProdottoColore;
import it.sirfin.ammazzonserver.model.VarianteColore;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
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
    
    @Query("SELECT pc FROM ProdottoColore pc WHERE pc.prodotto.id = :p")
    List<ProdottoColore> coloriAssociatiProdotto(@Param("p") Long id);

    //Query non funzionante per il momento
    @Query("SELECT pc FROM ProdottoColore pc WHERE pc.prodotto.id = :p")
    List<ProdottoColore> selezionaProdotto(@Param("p") Prodotto p);

    //Prova così
    @Query("SELECT pc FROM ProdottoColore pc WHERE pc.prodotto.id = :p")
    List<ProdottoColore> selezionaProdotto1(@Param("p") Long id);

}
