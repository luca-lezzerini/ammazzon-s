package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.VarianteTaglia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarianteTagliaRepository extends JpaRepository<VarianteTaglia, Long> {

}
