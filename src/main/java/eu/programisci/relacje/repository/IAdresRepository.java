package eu.programisci.relacje.repository;


import eu.programisci.relacje.ob.AdresOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdresRepository extends JpaRepository<AdresOB,Long> {

}
