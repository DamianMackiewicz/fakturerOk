package eu.programisci.relacje.repository;


import eu.programisci.relacje.ob.TelefonOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITelefonRepository extends JpaRepository<TelefonOB,Long> {
}
