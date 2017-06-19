package eu.programisci.relacje.ob;

import javax.persistence.*;

@Entity
@Table(name = "adresy")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_adresy_id")
public class AdresOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "pelnyAdres")
    private String pelnyAdres;

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getPelnyAdres() {
        return pelnyAdres;
    }

    public void setPelnyAdres(String aPelnyAdres) {
        pelnyAdres = aPelnyAdres;
    }
}
