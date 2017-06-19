package eu.programisci.relacje.repository;


import eu.programisci.relacje.dto.KlientDTO;
import eu.programisci.relacje.dto.KlientIAdresDTO;
import eu.programisci.relacje.dto.KlientIKontoDTO;
import eu.programisci.relacje.enums.ECechaKlienta;
import eu.programisci.relacje.ob.KlientOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IKlientRepository extends JpaRepository<KlientOB,Long> {

    // Klasyczny przyklad wiazania po sciezce (relacja po stronie klienta, wiec szukamy przez klienta).
    // Gdyby login (lub zestaw kryteriow wyszukiwania) byl w bazie danych oznaczony jako unikalny
    // mozliwe bylo by zwrocenie pojedynczego klienta zamiast listy, w przeciwnym wypadku jest to bledogenne.
    // Przyklad: GET /api/relacje/znajdzKlietowPoLoginie?login=janek
    @Query("SELECT new eu.programisci.relacje.dto.KlientDTO(k.id, k.imie, k.nazwisko) " +
            " FROM KlientOB k " +
            " LEFT JOIN k.konto a " +
            " WHERE a.login = :login ")
    List<KlientDTO> znajdzKlietowPoLoginie(@Param("login") String aLogin);

    // To samo, lecz zwracany obiekt jest troche wiekszy, w praktyce mozna sobie na to pozwolic bez problemu przy relacjach XToOne
    // W przeciwnym wypadku dostaniemy duplikaty (co moze byc pozadanym efektem).
    // Przyklad: GET /api/relacje/znajdzKlietowIKontaPoLoginie?login=janek
    @Query("SELECT new eu.programisci.relacje.dto.KlientIKontoDTO(k.id, k.imie, k.nazwisko, a.login, a.haslo) " +
            " FROM KlientOB k " +
            " LEFT JOIN k.konto a " +
            " WHERE a.login = :login ")
    List<KlientIKontoDTO> znajdzKlietowIKontaPoLoginie(@Param("login") String aLogin);

    // Takze wiazanie po sciezce, jednak wiecej niz 1 adres moze spelniac zadane kryteria, wiec zwracane bylyby duplikaty.
    // Jednym sposobem eliminacji duplikatow jest uzycie DISTINCT.
    // Bonus: mozna sprawdzic co sie stanie bez DISTINCTa
    // Przyklad: GET /api/relacje/znajdzKlientowPoCzesciowymAdresie?adres=olsztyn
    @Query("SELECT DISTINCT new eu.programisci.relacje.dto.KlientDTO(k.id, k.imie, k.nazwisko) " +
            " FROM KlientOB k " +
            " LEFT JOIN k.adresy a " +
            " WHERE upper(a.pelnyAdres) LIKE upper(concat('%',:adres,'%')) ")
    List<KlientDTO> znajdzKlientowPoCzesciowymAdresie(@Param("adres") String aAdres);

    // To co powyzej, lecz dodatkowo dostajemy informacje o adresach, ktore spelnialy kryteria, jednak sa one duplikowane.
    // Rozwiazac problem mozna na przyklad po stronie serwisu w Javie.
    // Ponizej przyklady z rozwiazanym problemem i bez rozwiazanego problemu
    // Przyklad: GET /api/relacje/znajdzKlientowIAdresyPoCzesciowymAdresieNoDuplicates?adres=olsztyn
    // Przyklad: GET /api/relacje/znajdzKlientowIAdresyPoCzesciowymAdresieWithDuplicates?adres=olsztyn
    @Query("SELECT DISTINCT new eu.programisci.relacje.dto.KlientIAdresDTO(k.id, k.imie, k.nazwisko, a.pelnyAdres) " +
            " FROM KlientOB k " +
            " LEFT JOIN k.adresy a " +
            " WHERE upper(a.pelnyAdres) LIKE upper(concat('%',:adres,'%')) ")
    List<KlientIAdresDTO> znajdzKlientowIAdresyPoCzesciowymAdresie(@Param("adres") String aAdres);

    // Innym sposobem eliminacji duplikatow jest uzycie MEMBER OF,
    // nie mozemy wowczas polegac na zwrocie danych, z ktorymi nastepuje wiazanie.
    // Przyklad: GET /api/relacje/znajdzKlientowZCecha?cecha=CHUDY
    @Query("SELECT new eu.programisci.relacje.dto.KlientDTO(k.id, k.imie, k.nazwisko) " +
            " FROM KlientOB k " +
            " WHERE :cecha MEMBER OF k.cechyKlienta ")
    List<KlientDTO> znajdzKlientowZCecha(@Param("cecha") ECechaKlienta aCecha);

    // Slabsze podejscie do pobierania danych, pomimo ze szukami klienta, dostaniemy caly zestaw danych:
    // adresy, telefony, subskrypcje, cechy i konto. Konwersja na JSON przy wyjsciu z RESTa dociagnie dane z bazy.
    // zrobi to 5 dodatkowych zapytan dla kazdego z pobranych klientow
    // Przyklad: GET /api/relacje/znajdzPelnychKlientowZCecha?cecha=WESOLY
    @Query("SELECT k " +
            " FROM KlientOB k " +
            " WHERE :cecha MEMBER OF k.cechyKlienta ")
    List<KlientOB> znajdzPelnychKlientowZCecha(@Param("cecha") ECechaKlienta aCecha);

    // Zrobi to co powyzej, ale przynajmniej dociagnie wszystkie dodatkowe dane od razu.
    // Wymaga nie tylko SETow zamiast LIST w encji, lecz takze DISTINCT w zapytaniu, w celu uninkiecia duplikatow
    // Przyklad: GET /api/relacje/znajdzPelnychKlientowZCechaFetch?cecha=WESOLY
    @Query("SELECT DISTINCT k " +
            " FROM KlientOB k " +
            " LEFT JOIN FETCH k.konto ac " +
            " LEFT JOIN FETCH k.cechyKlienta c " +
            " LEFT JOIN FETCH k.adresy a " +
            " LEFT JOIN FETCH k.telefony t " +
            " LEFT JOIN FETCH k.subskrypcje s " +
            " WHERE :cecha MEMBER OF k.cechyKlienta ")
    List<KlientOB> znajdzPelnychKlientowZCechaFetch(@Param("cecha") ECechaKlienta aCecha);

    // Wiazanie po id rodzica. Relacja lezy po stronie rodzica.
    // Przyklad: GET /api/relacje/znajdzTelefonyPoIdKlienta?klientId=1
    @Query("SELECT t.numer " +
            " FROM KlientOB k " +
            " LEFT JOIN k.telefony t " +
            " WHERE k.id = :klientId ")
    List<String> znajdzTelefonyPoIdKlienta(@Param("klientId") Long aKlientId);
}
