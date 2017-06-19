package eu.programisci.app.zwierzeta.converters;

/**
 * Created by student on 13.06.17.
 */
import eu.programisci.app.zwierzeta.dto.ZwierzeDTO;
import eu.programisci.app.zwierzeta.ob.ZwierzeOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZwierzeConverter {
    public ZwierzeDTO obToDto(ZwierzeOB in) {
        ZwierzeDTO out = new ZwierzeDTO();
        out.setId(in.getId());
        out.setNazwa(in.getNazwa());
        out.setGatunek(in.getGatunek());
        out.setPlec(in.getPlec());
        out.setWiek(in.getWiek());
        return out;
    }

    public ZwierzeOB dtoToOb(ZwierzeDTO in) {
        ZwierzeOB out = new ZwierzeOB();
        out.setId(in.getId());
        out.setNazwa(in.getNazwa());
        out.setGatunek(in.getGatunek());
        out.setPlec(in.getPlec());
        out.setWiek(in.getWiek());
        return out;
    }


    public List<ZwierzeDTO> obListToDtoList(List<ZwierzeOB> inList) {
        if (inList == null) {
            return null;
        }
        List<ZwierzeDTO> outList = new ArrayList<>();
        for (ZwierzeOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
