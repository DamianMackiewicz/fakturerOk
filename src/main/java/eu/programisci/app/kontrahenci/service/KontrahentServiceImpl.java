package eu.programisci.app.kontrahenci.service;

import eu.programisci.app.kontrahenci.converters.KontrahentConverter;
import eu.programisci.app.kontrahenci.dto.KontrahentDTO;
import eu.programisci.app.kontrahenci.ob.KontrahentOB;
import eu.programisci.app.kontrahenci.repository.IKontrahentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KontrahentServiceImpl implements IKontrahentService {

    @Autowired
    private IKontrahentRepository kontrahentRepository;

    @Autowired
    private KontrahentConverter kontrahentConverter;

    @Override
    public KontrahentDTO findOne(Long id) {
        KontrahentOB ob = kontrahentRepository.findOne(id);
        KontrahentDTO dto = kontrahentConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<KontrahentDTO> findAllForTable() {
        List<KontrahentOB> obList = kontrahentRepository.findAll();
        List<KontrahentDTO> dtoList = kontrahentConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        kontrahentRepository.delete(id);
    }

    @Override
    public KontrahentDTO save(KontrahentDTO dto) {
        if (dto.getId() == null) {
            return kontrahentConverter.obToDto(create(dto));
        } else {
            return kontrahentConverter.obToDto(update(dto));
        }
    }

    private KontrahentOB create(KontrahentDTO dto) {
        KontrahentOB ob = kontrahentConverter.dtoToOb(dto);
        ob.setCreationDate(new Date());
        ob = kontrahentRepository.save(ob);
        return ob;
    }

    private KontrahentOB update(KontrahentDTO dto) {
        KontrahentOB ob = kontrahentRepository.findOne(dto.getId());
        ob.setNazwa(dto.getNazwa());
        ob.setAdres(dto.getAdres());
        ob.setNip(dto.getNip());
        ob = kontrahentRepository.save(ob);
        return ob;
    }
}
