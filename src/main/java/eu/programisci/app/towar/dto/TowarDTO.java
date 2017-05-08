package eu.programisci.app.towar.dto;

import eu.programisci.app.towar.enums.EJednostkaMiary;

import java.util.Date;

/**
 * Created by student on 08.05.17.
 */
public class TowarDTO {

    private Long id;
    private String nazwa;
    private String pkwiu;
    private EJednostkaMiary jednostkaMiary;
    private Integer vat;
    private Double cenaNetto;
    private Date dataUtworzenia;

    public TowarDTO(){

    }

    public TowarDTO(String aNazwa, String aPkwiu, EJednostkaMiary aJednostakaMiary, Integer aVat, Double aCenaNetto){
        nazwa = aNazwa;
        pkwiu = aPkwiu;
        jednostkaMiary = aJednostakaMiary;
        vat = aVat;
        cenaNetto = aCenaNetto;
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

    public String getPkwiu() {
        return pkwiu;
    }

    public void setPkwiu(String aPkwiu) {
        pkwiu = aPkwiu;
    }

    public EJednostkaMiary getJednostkaMiary() {
        return jednostkaMiary;
    }

    public void setJednostkaMiary(EJednostkaMiary aJednostkaMiary) {
        jednostkaMiary = aJednostkaMiary;
    }

    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer aVat) {
        vat = aVat;
    }

    public Double getCenaNetto() {
        return cenaNetto;
    }

    public void setCenaNetto(Double aCenaNetto) {
        cenaNetto = aCenaNetto;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date aDataUtworzenia) {
        dataUtworzenia = aDataUtworzenia;
    }
}
