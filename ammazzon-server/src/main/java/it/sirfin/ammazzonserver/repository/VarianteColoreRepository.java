
package it.sirfin.ammazzonserver.repository;
import it.sirfin.ammazzonserver.model.VarianteColore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VarianteColoreRepository extends JpaRepository<VarianteColore, Long> {
    
}
