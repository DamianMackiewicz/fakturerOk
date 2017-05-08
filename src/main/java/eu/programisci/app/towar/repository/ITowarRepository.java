package eu.programisci.app.towar.repository;

import eu.programisci.app.towar.ob.TowarOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by student on 08.05.17.
 */
public interface ITowarRepository extends JpaRepository<TowarOB, Long>{
}
