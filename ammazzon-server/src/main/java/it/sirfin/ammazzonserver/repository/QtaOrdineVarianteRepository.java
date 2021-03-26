package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.QtaOrdineVariante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QtaOrdineVarianteRepository extends JpaRepository<QtaOrdineVariante, Long> {

}
