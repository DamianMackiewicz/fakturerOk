package eu.programisci.relacje.repository;


import eu.programisci.relacje.ob.EmailOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmailRepository extends JpaRepository<EmailOB,Long> {

    // Wiazanie po id rodzica. Relacja lezy po stronie dziecka.
    // Przyklad: GET /api/relacje/znajdzEmailePoIdKlienta?klientId=1
    @Query("SELECT t.adres FROM EmailOB t WHERE t.klient.id = :klientId")
    List<String> znajdzEmailePoIdKlienta(@Param("klientId") Long aKlientId);
}
