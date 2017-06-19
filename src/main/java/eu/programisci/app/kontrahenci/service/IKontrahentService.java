package eu.programisci.app.kontrahenci.service;

import eu.programisci.app.kontrahenci.dto.KontrahentDTO;

import java.util.List;

public interface IKontrahentService {

    KontrahentDTO findOne(Long id);

    List<KontrahentDTO> findAllForTable();

    void deleteOne(Long id);

    KontrahentDTO save(KontrahentDTO userDTO);
}
