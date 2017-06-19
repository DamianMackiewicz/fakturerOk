package eu.programisci.relacje.dto;

public class KlientIAdresDTO {

    private Long id;
    private String imie;
    private String nazwisko;
    private String adres;

    public KlientIAdresDTO() {
    }

    public KlientIAdresDTO(Long aId, String aImie, String aNazwisko, String aAdres) {
        id = aId;
        imie = aImie;
        nazwisko = aNazwisko;
        adres = aAdres;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String aAdres) {
        adres = aAdres;
    }
}
