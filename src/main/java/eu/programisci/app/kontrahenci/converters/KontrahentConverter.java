package eu.programisci.app.kontrahenci.converters;

import eu.programisci.app.kontrahenci.dto.KontrahentDTO;
import eu.programisci.app.kontrahenci.ob.KontrahentOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KontrahentConverter {

    public KontrahentDTO obToDto(KontrahentOB in) {
        KontrahentDTO out = new KontrahentDTO();
        out.setId(in.getId());
        out.setNazwa(in.getNazwa());
        out.setAdres(in.getAdres());
        out.setNip(in.getNip());
        return out;
    }

    public KontrahentOB dtoToOb(KontrahentDTO in) {
        KontrahentOB out = new KontrahentOB();
        out.setId(in.getId());
        out.setNazwa(in.getNazwa());
        out.setAdres(in.getAdres());
        out.setNip(in.getNip());
        return out;
    }


    public List<KontrahentDTO> obListToDtoList(List<KontrahentOB> inList) {
        if (inList == null) {
            return null;
        }
        List<KontrahentDTO> outList = new ArrayList<>();
        for (KontrahentOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }
}
