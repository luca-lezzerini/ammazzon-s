package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.VarianteTaglia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VarianteTagliaRepository extends JpaRepository<VarianteTaglia, Long> {

    @Query("select c from VarianteTaglia c where c.codice =:cr ")
    Page<VarianteTaglia> trovaCodice(@Param("cr") String criterio, Pageable p);
}
