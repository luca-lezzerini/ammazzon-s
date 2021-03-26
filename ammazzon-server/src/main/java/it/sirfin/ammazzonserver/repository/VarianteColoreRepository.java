package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.VarianteColore;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VarianteColoreRepository extends JpaRepository<VarianteColore, Long> {

    //ListaColoriDto findByCodiceContains(String c);
    @Query("select c from VarianteColore c where c.codice =:criterio")
    List<VarianteColore> trovaCodice(@Param("criterio") String criterio);
    
    
//     @Query("select c from Cassiera c where c.nome LIKE CONCAT('%',:cogn,'%') "
//            + "or c.cognome LIKE CONCAT('%',:cogn,'%') or c.codiceFiscale"
//            + "=:cogn")
}


