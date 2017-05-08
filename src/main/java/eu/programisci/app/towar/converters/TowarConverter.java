package eu.programisci.app.towar.converters;

import eu.programisci.app.towar.dto.TowarDTO;
import eu.programisci.app.towar.ob.TowarOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by student on 08.05.17.
 */
@Service
public class TowarConverter {

    public TowarDTO obToDto(TowarOB in) {
        TowarDTO out = new TowarDTO();
        out.setId(in.getId());
        out.setDataUtworzenia(in.getDataUtworzenia());
        out.setNazwa(in.getNazwa());
        out.setPkwiu(in.getPkwiu());
        out.setJednostkaMiary(in.getJednostkaMiary());
        out.setVat(in.getVat());
        out.setCenaNetto(in.getCenaNetto());
        return out;
    }

    public TowarOB dtoToOb(TowarDTO in) {
        TowarOB out = new TowarOB();
        out.setId(in.getId());
        out.setDataUtworzenia(in.getDataUtworzenia());
        out.setNazwa(in.getNazwa());
        out.setPkwiu(in.getPkwiu());
        out.setJednostkaMiary(in.getJednostkaMiary());
        out.setVat(in.getVat());
        out.setCenaNetto(in.getCenaNetto());
        return out;
    }

    public List<TowarDTO> towarObToTowar(List<TowarOB> inList) {
        if (inList == null) {
            return null;
        }
        List<TowarDTO> outList = new ArrayList<>();
        for (TowarOB in : inList) {
            outList.add(towarObToTowar(in));
        }
        return outList;
    }

    private TowarDTO towarObToTowar(TowarOB in) {
        TowarDTO out = new TowarDTO();
        out.setId(in.getId());
        out.setDataUtworzenia(in.getDataUtworzenia());
        out.setNazwa(in.getNazwa());
        out.setPkwiu(in.getPkwiu());
        out.setJednostkaMiary(in.getJednostkaMiary());
        out.setVat(in.getVat());
        out.setCenaNetto(in.getCenaNetto());
        return out;
    }
}
