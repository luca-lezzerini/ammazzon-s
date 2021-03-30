package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.UtenteRegistrato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRegistratoRepository extends JpaRepository<UtenteRegistrato, Long> {

    @Query("select c from UtenteRegistrato c where c.nome LIKE CONCAT('%',:cogn,'%')"
            + " or c.cognome LIKE CONCAT('%',:cogn,'%')"
            + " or c.username LIKE CONCAT('%',:cogn,'%')"
            + " or c.codiceFiscale =:cogn")
    Page<UtenteRegistrato> trovaUtenteRegistrato(@Param("cogn") String cognome, Pageable pageable);
    
}
