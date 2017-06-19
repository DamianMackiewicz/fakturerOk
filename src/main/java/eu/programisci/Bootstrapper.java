package eu.programisci;

import eu.programisci.Test.user.dto.UserDTO;
import eu.programisci.Test.user.service.IUserService;
import eu.programisci.app.zwierzeta.dto.ZwierzeDTO;
import eu.programisci.app.zwierzeta.enums.EGatunek;
import eu.programisci.app.zwierzeta.enums.EPlec;
import eu.programisci.app.zwierzeta.service.IZwierzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class Bootstrapper implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private IUserService userService;

    @Autowired
    private IZwierzeService zwierzeService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Tutaj wykonuje sie import danych");

        userService.save(new UserDTO("Jan", "Kowalski", "j.kowalski", "tajneHaslo123", "j.kowalski@wp.pl"));
        userService.save(new UserDTO("Adam", "Nowak", "a.nowak", "tajneHaslo123", "a.nowak@wp.pl"));
        userService.save(new UserDTO("Stefan", "Batory", "s.batory", "tajneHaslo123", "s.batory@wp.pl"));
        userService.save(new UserDTO("Anna", "Kowalska", "a.kowalska", "tajneHaslo123", "a.kowalska@wp.pl"));
        userService.save(new UserDTO("Zenon", "Zenon", "z.zenon", "tajneHaslo123", "z.zenon@wp.pl"));
        userService.save(new UserDTO("Krzysztof", "Nazwisko", "k.nazwisko", "tajneHaslo123", "k.nazwisko@wp.pl"));

        zwierzeService.save(new ZwierzeDTO("Azor", EGatunek.PIES, EPlec.SAMIEC, 4));
        zwierzeService.save(new ZwierzeDTO("Hańba", EGatunek.PIES, EPlec.SAMICA, 3));
        zwierzeService.save(new ZwierzeDTO("Mruczek", EGatunek.KOT, EPlec.SAMIEC, 4));
        zwierzeService.save(new ZwierzeDTO("Diabuś", EGatunek.KOT, EPlec.SAMIEC, 3));
        zwierzeService.save(new ZwierzeDTO("Zenek", EGatunek.JASZCZURKA, EPlec.SAMIEC, 1));
    }
}
