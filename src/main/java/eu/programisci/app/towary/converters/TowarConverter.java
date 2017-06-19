package eu.programisci.app.towary.converters;

import eu.programisci.app.towary.dto.TowarDTO;
import eu.programisci.app.towary.ob.TowarOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TowarConverter {

    public TowarDTO obToDto(TowarOB in) {
        TowarDTO out = new TowarDTO();
        out.setId(in.getId());
        out.setNazwa(in.getNazwa());
        out.setJednostkaMiary(in.getJednostkaMiary());
        out.setCenaNetto(in.getCenaNetto());
        out.setPkwiu(in.getPkwiu());
        out.setVat(in.getVat());
        return out;
    }

    public TowarOB dtoToOb(TowarDTO in) {
        TowarOB out = new TowarOB();
        out.setId(in.getId());
        out.setNazwa(in.getNazwa());
        out.setJednostkaMiary(in.getJednostkaMiary());
        out.setCenaNetto(in.getCenaNetto());
        out.setPkwiu(in.getPkwiu());
        out.setVat(in.getVat());
        return out;
    }


    public List<TowarDTO> obListToDtoList(List<TowarOB> inList) {
        if (inList == null) {
            return null;
        }
        List<TowarDTO> outList = new ArrayList<>();
        for (TowarOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
