package eu.programisci.app.towar.service;

import eu.programisci.app.towar.converters.TowarConverter;
import eu.programisci.app.towar.dto.TowarDTO;
import eu.programisci.app.towar.ob.TowarOB;
import eu.programisci.app.towar.repository.ITowarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * Created by student on 08.05.17.
 */

@Service
public class TowarServiceImpl implements ITowarService {

    @Autowired
    private ITowarRepository towarRepository;

    @Autowired
    private TowarConverter towarConverter;

    @Override
    public TowarDTO findOne(Long id) {
        TowarOB ob = towarRepository.findOne(id);
        TowarDTO dto = towarConverter.obToDto(ob);
        return dto;
    }

    @Override
    public List<TowarDTO> findAll() {
        List<TowarOB> obList = towarRepository.findAll();
        List<TowarDTO> dtoList = towarConverter.towarObToTowar(obList);
        return dtoList;
    }

    @Override
    public void deleteOne(Long id) {
        towarRepository.delete(id);
    }

    @Override
    public TowarDTO save(TowarDTO dto) {
        if (dto.getId() == null) {
            return towarConverter.obToDto(create(dto));
        } else {
            return towarConverter.obToDto(update(dto));
        }
    }

    private TowarOB create(TowarDTO dto) {
        TowarOB ob = towarConverter.dtoToOb(dto);
        ob.setDataUtworzenia(new Date());
        ob = towarRepository.save(ob);
        return ob;
    }

    private TowarOB update(TowarDTO dto) {
        TowarOB ob = towarRepository.findOne(dto.getId());
        ob.setNazwa(dto.getNazwa());
        ob.setPkwiu(dto.getPkwiu());
        ob.setJednostkaMiary(dto.getJednostkaMiary());
        ob.setVat(dto.getVat());
        ob.setCenaNetto(dto.getCenaNetto());
        ob = towarRepository.save(ob);
        return ob;
    }
}
