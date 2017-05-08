package eu.programisci.app.kontrahent.repository;

import eu.programisci.app.kontrahent.ob.KontrahentOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by student on 25.04.17.
 */

@Repository
public interface IKontrahentRepository extends JpaRepository<KontrahentOB, Long> {

}

