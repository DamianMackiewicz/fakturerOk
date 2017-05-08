package eu.programisci.app.kontrahent.dto;

import java.util.Date;

/**
 * Created by student on 25.04.17.
 */

public class KontrahentDTO {

    private Long id;
    private String nazwa;
    private String adres;
    private String nip;
    private Date dataUtworzenia;

    public KontrahentDTO(){

    }

    public KontrahentDTO(String aNazwa, String aAdres, String aNip) {
        nazwa = aNazwa;
        adres = aAdres;
        nip = aNip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String aNazwa) {
        nazwa = aNazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String aAdres) {
        adres = aAdres;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String aNip) {
        nip = aNip;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date aDataUtworzenia) {
        dataUtworzenia = aDataUtworzenia;
    }
}
