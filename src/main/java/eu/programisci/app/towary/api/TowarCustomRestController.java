package eu.programisci.app.towary.api;

import eu.programisci.app.towary.dto.TowarDTO;
import eu.programisci.app.towary.dto.TowarLightDTO;
import eu.programisci.app.towary.service.ITowarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/towar")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class TowarCustomRestController {

    @Autowired
    private ITowarService towarService;

    @RequestMapping(value = "/findByNazwa", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TowarDTO> findByNazwa(@RequestParam("nazwa") String aNazwa) {
        return towarService.findByNazwa(aNazwa);
    }

    @RequestMapping(value = "/findByNazwaStartingWith", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TowarDTO> findByNazwaStartingWith(@RequestParam("nazwa") String aNazwa) {
        return towarService.findByNazwaStartingWith(aNazwa);
    }

    @RequestMapping(value = "/findByNazwaLikeIgnoreCaseOrderByIdDesc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TowarDTO> findByNazwaLikeIgnoreCaseOrderByIdDesc(@RequestParam("nazwa") String aNazwa) {
        return towarService.findByNazwaLikeIgnoreCaseOrderByIdDesc("%" + aNazwa + "%");
    }

    @RequestMapping(value = "/znajdzLikeNazwaICbyIdAsc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TowarDTO> znajdzLikeNazwaICbyIdAsc(@RequestParam("nazwa") String aNazwa) {
        return towarService.znajdzLikeNazwaICbyIdAsc(aNazwa);
    }

    @RequestMapping(value = "/znajdzLikeNazwaICbyIdAscParam", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TowarDTO> znajdzLikeNazwaICbyIdAscParam(@RequestParam("nazwa") String aNazwa) {
        return towarService.znajdzLikeNazwaICbyIdAscParam(aNazwa);
    }

    @RequestMapping(value = "/znajdzWszystkieWersjaLight", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TowarLightDTO> znajdzWszystkieWersjaLight() {
        return towarService.znajdzWszystkieWersjaLight();
    }

    @RequestMapping(value = "/znajdzWszystkiePowyzejCeny", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TowarLightDTO> znajdzWszystkiePowyzejCeny(@RequestParam("cenaNetto") Double aCenaNetto) {
        return towarService.znajdzWszystkiePowyzejCeny(aCenaNetto);
    }

    @RequestMapping(value = "/znajdzPoId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TowarDTO znajdzPoId(@RequestParam("id") Long aId) {
        return towarService.znajdzPoId(aId);
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TowarDTO> init() {
        return towarService.init();
    }

    @RequestMapping(value = "/forceUpdate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void forceUpdate(@RequestParam("nazwa") String aNazwa) {
        towarService.forceUpdate(aNazwa);
    }
}
