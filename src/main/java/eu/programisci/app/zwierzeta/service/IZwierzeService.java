package eu.programisci.app.zwierzeta.service;

import eu.programisci.app.zwierzeta.dto.ZwierzeDTO;

import java.util.List;

/**
 * Created by student on 13.06.17.
 */
public interface IZwierzeService {
    ZwierzeDTO findOne(Long id);
    List<ZwierzeDTO> findAll();
    void deleteOne(Long id);
    ZwierzeDTO save(ZwierzeDTO zwierzeDTO);
}
