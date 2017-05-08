package eu.programisci.app.towar.service;


import eu.programisci.app.towar.dto.TowarDTO;
import eu.programisci.app.towar.ob.TowarOB;

import java.util.List;

/**
 * Created by student on 08.05.17.
 */
public interface ITowarService {

    TowarDTO findOne(Long id);
    List<TowarDTO> findAll();
    void deleteOne(Long id);
    TowarDTO save (TowarDTO towarDTO);
}
