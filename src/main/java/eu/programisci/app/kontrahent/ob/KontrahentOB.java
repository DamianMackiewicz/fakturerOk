package eu.programisci.app.kontrahent.ob;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by student on 25.04.17.
 */

@Entity
@Table(name = "kontrahenci")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_kontrahenci_id")
public class KontrahentOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "data_utworzenia", columnDefinition = "TIMESTAMP")
    private Date dataUtworzenia;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "adres")
    private String adres;

    @Column(name = "nip")
    private String nip;

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
