package eu.programisci.relacje.api;

import eu.programisci.relacje.dto.KlientDTO;
import eu.programisci.relacje.dto.KlientIAdresDTO;
import eu.programisci.relacje.dto.KlientIKontoDTO;
import eu.programisci.relacje.dto.KlientZAdresamiDTO;
import eu.programisci.relacje.enums.ECechaKlienta;
import eu.programisci.relacje.ob.KlientOB;
import eu.programisci.relacje.service.IRelacjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/relacje")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class RelacjeRestController {

    @Autowired
    private IRelacjeService relacjeService;

    @RequestMapping(value = "/init", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void init() {
        relacjeService.init();
    }

    @RequestMapping(value = "/znajdzKlietowPoLoginie", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<KlientDTO> znajdzKlietowPoLoginie(@RequestParam("login") String aLogin) {
        return relacjeService.znajdzKlietowPoLoginie(aLogin);
    }

    @RequestMapping(value = "/znajdzKlietowIKontaPoLoginie", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<KlientIKontoDTO> znajdzKlietowIKontaPoLoginie(@RequestParam("login") String aLogin) {
        return relacjeService.znajdzKlietowIKontaPoLoginie(aLogin);
    }

    @RequestMapping(value = "/znajdzKlientowPoCzesciowymAdresie", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<KlientDTO> znajdzKlientowPoCzesciowymAdresie(@RequestParam("adres") String aAdres) {
        return relacjeService.znajdzKlientowPoCzesciowymAdresie(aAdres);
    }

    @RequestMapping(value = "/znajdzKlientowIAdresyPoCzesciowymAdresieNoDuplicates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<KlientZAdresamiDTO> znajdzKlientowIAdresyPoCzesciowymAdresieNoDuplicates(@RequestParam("adres") String aAdres) {
        return relacjeService.znajdzKlientowIAdresyPoCzesciowymAdresieNoDuplicates(aAdres);
    }

    @RequestMapping(value = "/znajdzKlientowIAdresyPoCzesciowymAdresieWithDuplicates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<KlientIAdresDTO> znajdzKlientowIAdresyPoCzesciowymAdresieWithDuplicates(@RequestParam("adres") String aAdres) {
        return relacjeService.znajdzKlientowIAdresyPoCzesciowymAdresieWithDuplicates(aAdres);
    }

    @RequestMapping(value = "/znajdzKlientowZCecha", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<KlientDTO> znajdzKlientowZCecha(@RequestParam("cecha") ECechaKlienta aCecha) {
        return relacjeService.znajdzKlientowZCecha(aCecha);
    }

    @RequestMapping(value = "/znajdzPelnychKlientowZCecha", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<KlientOB> znajdzPelnychKlientowZCecha(@RequestParam("cecha") ECechaKlienta aCecha) {
        return relacjeService.znajdzPelnychKlientowZCecha(aCecha);
    }

    @RequestMapping(value = "/znajdzPelnychKlientowZCechaFetch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<KlientOB> znajdzPelnychKlientowZCechaFetch(@RequestParam("cecha") ECechaKlienta aCecha) {
        return relacjeService.znajdzPelnychKlientowZCechaFetch(aCecha);
    }

    @RequestMapping(value = "/znajdzTelefonyPoIdKlienta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> znajdzTelefonyPoIdKlienta(@RequestParam("klientId") Long aKlientId) {
        return relacjeService.znajdzTelefonyPoIdKlienta(aKlientId);
    }

    @RequestMapping(value = "/znajdzEmailePoIdKlienta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> znajdzEmailePoIdKlienta(@RequestParam("klientId") Long aKlientId) {
        return relacjeService.znajdzEmailePoIdKlienta(aKlientId);
    }
}
