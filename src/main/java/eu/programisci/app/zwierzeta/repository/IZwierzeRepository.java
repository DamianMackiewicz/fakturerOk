package eu.programisci.app.zwierzeta.repository;

import eu.programisci.app.zwierzeta.ob.ZwierzeOB;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by student on 13.06.17.
 */
public interface IZwierzeRepository extends JpaRepository<ZwierzeOB, Long> {

}
