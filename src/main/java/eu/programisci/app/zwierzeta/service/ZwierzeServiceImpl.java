package eu.programisci.app.zwierzeta.service;

import eu.programisci.app.zwierzeta.converters.ZwierzeConverter;
import eu.programisci.app.zwierzeta.dto.ZwierzeDTO;
import eu.programisci.app.zwierzeta.ob.ZwierzeOB;
import eu.programisci.app.zwierzeta.repository.IZwierzeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;


/**
 * Created by student on 13.06.17.
 */
@Service
public class ZwierzeServiceImpl implements IZwierzeService{

    @Autowired
    private IZwierzeRepository zwierzeRepository;

    @Autowired
    private ZwierzeConverter zwierzeConverter;

    @Override
    public ZwierzeDTO findOne(Long id) {
        ZwierzeOB ob = zwierzeRepository.findOne(id);
        ZwierzeDTO dto = zwierzeConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<ZwierzeDTO> findAll() {
        List<ZwierzeOB> obList = zwierzeRepository.findAll();
        List<ZwierzeDTO> dtoList = zwierzeConverter.obListToDtoList(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        zwierzeRepository.delete(id);
    }

    @Override
    public ZwierzeDTO save(ZwierzeDTO dto) {
        if (dto.getId() == null) {
            return zwierzeConverter.obToDto(create(dto));
        } else {
            return zwierzeConverter.obToDto(update(dto));
        }
    }

    private ZwierzeOB create(ZwierzeDTO dto) {
        ZwierzeOB ob = zwierzeConverter.dtoToOb(dto);
        ob.setDataUtworzenia(new Date());
        ob = zwierzeRepository.save(ob);
        return ob;
    }

    private ZwierzeOB update(ZwierzeDTO dto) {
        ZwierzeOB ob = zwierzeRepository.findOne(dto.getId());
        ob.setNazwa(dto.getNazwa());
        ob.setGatunek(dto.getGatunek());
        ob.setPlec(dto.getPlec());
        ob.setWiek(dto.getWiek());
        ob = zwierzeRepository.save(ob);
        return ob;
    }
}
