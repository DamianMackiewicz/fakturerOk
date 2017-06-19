package eu.programisci.app.towary.dto;

public class TowarLightDTO {

    private Long id;
    private String nazwa;
    private Double cenaNetto;

    public TowarLightDTO() {
    }

    public TowarLightDTO(Long aId, String aNazwa, Double aCenaNetto) {
        id = aId;
        nazwa = aNazwa;
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

    public Double getCenaNetto() {
        return cenaNetto;
    }

    public void setCenaNetto(Double aCenaNetto) {
        cenaNetto = aCenaNetto;
    }
}
