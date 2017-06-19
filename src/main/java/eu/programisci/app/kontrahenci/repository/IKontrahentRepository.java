package eu.programisci.app.kontrahenci.repository;


import eu.programisci.app.kontrahenci.ob.KontrahentOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKontrahentRepository extends JpaRepository<KontrahentOB,Long> {

}
