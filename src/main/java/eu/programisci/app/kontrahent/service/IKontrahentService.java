package eu.programisci.app.kontrahent.service;

import eu.programisci.app.kontrahent.dto.KontrahentDTO;

import java.util.List;

/**
 * Created by student on 25.04.17.
 */
public interface IKontrahentService {

    KontrahentDTO findOne(Long id);

    List<KontrahentDTO> findAll();

    void deleteOne(Long id);

    KontrahentDTO save(KontrahentDTO kontrahentDTO);
}
