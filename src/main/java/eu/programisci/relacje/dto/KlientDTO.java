package eu.programisci.relacje.dto;

public class KlientDTO {

    private Long id;
    private String imie;
    private String nazwisko;

    public KlientDTO() {
    }

    public KlientDTO(Long aId, String aImie, String aNazwisko) {
        id = aId;
        imie = aImie;
        nazwisko = aNazwisko;
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
}
