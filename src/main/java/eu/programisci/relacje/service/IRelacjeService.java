package eu.programisci.relacje.service;

import eu.programisci.relacje.dto.KlientDTO;
import eu.programisci.relacje.dto.KlientIAdresDTO;
import eu.programisci.relacje.dto.KlientIKontoDTO;
import eu.programisci.relacje.dto.KlientZAdresamiDTO;
import eu.programisci.relacje.enums.ECechaKlienta;
import eu.programisci.relacje.ob.KlientOB;

import java.util.List;

public interface IRelacjeService {

    void init();

    List<KlientDTO> znajdzKlietowPoLoginie(String aLogin);

    List<KlientIKontoDTO> znajdzKlietowIKontaPoLoginie(String aLogin);

    List<KlientDTO> znajdzKlientowPoCzesciowymAdresie(String aAdres);

    List<KlientZAdresamiDTO> znajdzKlientowIAdresyPoCzesciowymAdresieNoDuplicates(String aAdres);

    List<KlientIAdresDTO> znajdzKlientowIAdresyPoCzesciowymAdresieWithDuplicates(String aAdres);

    List<KlientDTO> znajdzKlientowZCecha(ECechaKlienta aCecha);

    List<KlientOB> znajdzPelnychKlientowZCecha(ECechaKlienta aCecha);

    List<KlientOB> znajdzPelnychKlientowZCechaFetch(ECechaKlienta aCecha);

    List<String> znajdzTelefonyPoIdKlienta(Long aKlientId);

    List<String> znajdzEmailePoIdKlienta(Long aKlientId);
}
