package eu.programisci.relacje.dto;

public class KlientIKontoDTO {

    private Long id;
    private String imie;
    private String nazwisko;
    private String login;
    private String haslo;

    public KlientIKontoDTO() {
    }

    public KlientIKontoDTO(Long aId, String aImie, String aNazwisko, String aLogin, String aHaslo) {
        id = aId;
        imie = aImie;
        nazwisko = aNazwisko;
        login = aLogin;
        haslo = aHaslo;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String aLogin) {
        login = aLogin;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String aHaslo) {
        haslo = aHaslo;
    }
}
