package eu.programisci.app.towary.dto;

import eu.programisci.app.towary.enums.EJednostkaMiary;

public class TowarDTO {

    private Long id;
    private String nazwa;
    private String pkwiu;
    private EJednostkaMiary jednostkaMiary;
    private Integer vat;
    private Double cenaNetto;

    public TowarDTO() {
    }

    public TowarDTO(Long aId, String aNazwa, String aPkwiu, EJednostkaMiary aJednostkaMiary, Integer aVat, Double aCenaNetto) {
        id = aId;
        nazwa = aNazwa;
        pkwiu = aPkwiu;
        jednostkaMiary = aJednostkaMiary;
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
}
