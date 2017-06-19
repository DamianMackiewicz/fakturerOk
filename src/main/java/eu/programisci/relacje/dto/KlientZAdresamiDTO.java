package eu.programisci.relacje.dto;

import java.util.List;

public class KlientZAdresamiDTO {

    private Long id;
    private String imie;
    private String nazwisko;
    private List<String> adresy;

    public KlientZAdresamiDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String aImie) {
        imie = aImie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String aNazwisko) {
        nazwisko = aNazwisko;
    }

    public List<String> getAdresy() {
        return adresy;
    }

    public void setAdresy(List<String> aAdresy) {
        adresy = aAdresy;
    }
}
