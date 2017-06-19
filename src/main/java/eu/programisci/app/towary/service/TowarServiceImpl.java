package eu.programisci.app.towary.service;

import eu.programisci.app.towary.converters.TowarConverter;
import eu.programisci.app.towary.dto.TowarDTO;
import eu.programisci.app.towary.dto.TowarLightDTO;
import eu.programisci.app.towary.enums.EJednostkaMiary;
import eu.programisci.app.towary.ob.TowarOB;
import eu.programisci.app.towary.repository.ITowarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public List<TowarDTO> findAllForTable() {
        List<TowarOB> obList = towarRepository.findAll();
        List<TowarDTO> dtoList = towarConverter.obListToDtoList(obList);
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
        ob.setCreationDate(new Date());
        ob = towarRepository.save(ob);
        return ob;
    }

    private TowarOB update(TowarDTO dto) {
        TowarOB ob = towarRepository.findOne(dto.getId());
        ob.setNazwa(dto.getNazwa());
        ob.setJednostkaMiary(dto.getJednostkaMiary());
        ob.setCenaNetto(dto.getCenaNetto());
        ob.setPkwiu(dto.getPkwiu());
        ob.setVat(dto.getVat());
        ob = towarRepository.save(ob);
        return ob;
    }


    // --------------------- customowe zapytania ----------------------

    @Override
    public List<TowarDTO> findByNazwa(String aNazwa) {
        List<TowarOB> pOBList = towarRepository.findByNazwa(aNazwa);
        List<TowarDTO> pDTOList = towarConverter.obListToDtoList(pOBList);
        return pDTOList;
    }

    @Override
    public List<TowarDTO> findByNazwaStartingWith(String aNazwa) {
        List<TowarOB> pOBList = towarRepository.findByNazwaStartingWith(aNazwa);
        List<TowarDTO> pDTOList = towarConverter.obListToDtoList(pOBList);
        return pDTOList;
    }

    @Override
    public List<TowarDTO> findByNazwaLikeIgnoreCaseOrderByIdDesc(String aNazwa) {
        List<TowarOB> pOBList = towarRepository.findByNazwaLikeIgnoreCaseOrderByIdDesc(aNazwa);
        List<TowarDTO> pDTOList = towarConverter.obListToDtoList(pOBList);
        return pDTOList;
    }

    @Override
    public List<TowarDTO> znajdzLikeNazwaICbyIdAsc(String aNazwa) {
        List<TowarOB> pOBList = towarRepository.znajdzLikeNazwaICbyIdAsc(aNazwa);
        List<TowarDTO> pDTOList = towarConverter.obListToDtoList(pOBList);
        return pDTOList;
    }

    @Override
    public List<TowarDTO> znajdzLikeNazwaICbyIdAscParam(String aNazwa) {
        List<TowarOB> pOBList = towarRepository.znajdzLikeNazwaICbyIdAscParam(aNazwa);
        List<TowarDTO> pDTOList = towarConverter.obListToDtoList(pOBList);
        return pDTOList;
    }

    @Override
    public List<TowarLightDTO> znajdzWszystkieWersjaLight() {
        return towarRepository.znajdzWszystkieWersjaLight();
    }

    @Override
    public List<TowarLightDTO> znajdzWszystkiePowyzejCeny(Double aCenaNetto) {
        return towarRepository.znajdzWszystkiePowyzejCeny(aCenaNetto);
    }

    @Override
    public TowarDTO znajdzPoId(Long aId) {
        TowarOB pOB = towarRepository.znajdzPoId(aId);
        TowarDTO pDTO = towarConverter.obToDto(pOB);
        return pDTO;
    }

    @Override
    public List<TowarDTO> init() {
        List<TowarOB> pOBList = new ArrayList<>();
        pOBList.add(towarConverter.dtoToOb(new TowarDTO(null, "Woda mineralna niegazowana", "10.15", EJednostkaMiary.LITR, 22, 1.75)));
        pOBList.add(towarConverter.dtoToOb(new TowarDTO(null, "Woda mineralna gazowana", "10.15", EJednostkaMiary.LITR, 22, 1.80)));
        pOBList.add(towarConverter.dtoToOb(new TowarDTO(null, "Woda destylowana", "08.22", EJednostkaMiary.LITR, 22, 3.25)));
        pOBList.add(towarConverter.dtoToOb(new TowarDTO(null, "Woda utleniona 150ml", "45.32", EJednostkaMiary.SZTUKA, 13, 5.00)));
        pOBList.add(towarConverter.dtoToOb(new TowarDTO(null, "Cukier", "02.02", EJednostkaMiary.KILOGRAM, 22, 3.50)));
        pOBList.add(towarConverter.dtoToOb(new TowarDTO(null, "Makaron", "02.17", EJednostkaMiary.SZTUKA, 22, 4.20)));
        pOBList.add(towarConverter.dtoToOb(new TowarDTO(null, "Mydło", "08.35", EJednostkaMiary.SZTUKA, 22, 2.80)));
        pOBList.add(towarConverter.dtoToOb(new TowarDTO(null, "Szampon", "08.98", EJednostkaMiary.SZTUKA, 22, 5.00)));
        pOBList = towarRepository.save(pOBList);
        return towarConverter.obListToDtoList(pOBList);
    }

    @Transactional
    @Override
    public void forceUpdate(String aNazwa) {
        towarRepository.forceUpdate(aNazwa);
    }
}
