package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.VarianteColore;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VarianteColoreRepository extends JpaRepository<VarianteColore, Long> {

    //ListaColoriDto findByCodiceContains(String c);
    @Query("select c from VarianteColore c where c.codice =:criterio")
    Page<VarianteColore> trovaCodice(@Param("criterio") String criterio, Pageable pageable);

//    @Query(value = "select * from VarianteColore where codice =:cod",
//            countQuery = "select count(*) from VarianteColore where codice =:cod",
//            nativeQuery= true)
//    Page<VarianteColore> trovaCodicePaginato(@Param("cod") String codice, Pageable pageable );
    
    @Query("select v from VarianteColore v")
    Page<VarianteColore> cercaTuttiPaginato(Pageable pageable);
}


