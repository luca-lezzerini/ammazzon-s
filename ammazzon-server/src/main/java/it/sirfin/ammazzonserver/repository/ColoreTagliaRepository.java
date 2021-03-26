package it.sirfin.ammazzonserver.repository;

import it.sirfin.ammazzonserver.model.ColoreTaglia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColoreTagliaRepository extends JpaRepository<ColoreTaglia, Long> {

}
