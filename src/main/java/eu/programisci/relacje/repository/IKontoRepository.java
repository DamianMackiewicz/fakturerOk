package eu.programisci.relacje.repository;


import eu.programisci.relacje.ob.KontoOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKontoRepository extends JpaRepository<KontoOB,Long> {

}
