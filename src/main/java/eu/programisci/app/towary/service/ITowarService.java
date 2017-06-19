package eu.programisci.app.towary.service;

import eu.programisci.app.towary.dto.TowarDTO;
import eu.programisci.app.towary.dto.TowarLightDTO;

import java.util.List;

public interface ITowarService {

    TowarDTO findOne(Long id);

    List<TowarDTO> findAllForTable();

    void deleteOne(Long id);

    TowarDTO save(TowarDTO userDTO);

    List<TowarDTO> findByNazwa(String aNazwa);

    List<TowarDTO> findByNazwaStartingWith(String aNazwa);

    List<TowarDTO> findByNazwaLikeIgnoreCaseOrderByIdDesc(String aNazwa);

    List<TowarDTO> znajdzLikeNazwaICbyIdAsc(String aNazwa);

    List<TowarDTO> znajdzLikeNazwaICbyIdAscParam(String aNazwa);

    List<TowarLightDTO> znajdzWszystkieWersjaLight();

    List<TowarLightDTO> znajdzWszystkiePowyzejCeny(Double aCenaNetto);

    TowarDTO znajdzPoId(Long aId);

    List<TowarDTO> init();

    void forceUpdate(String aNazwa);
}
