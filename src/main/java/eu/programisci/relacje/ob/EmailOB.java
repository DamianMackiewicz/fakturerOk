package eu.programisci.relacje.ob;

import javax.persistence.*;

@Entity
@Table(name = "emaile")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_emaile_id")
public class EmailOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "adres")
    private String adres;

    // jeden klient moze miec wiele adresow email, ale kazdy z nich bedzie przypisany tylko do jednego klienta
    // dodatkowo wprowadzono tutaj wymog, ze adres email nie moze istniec bez klenta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klient_id", referencedColumnName="id", nullable = false)
    private KlientOB klient;

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String aAdres) {
        adres = aAdres;
    }

    public KlientOB getKlient() {
        return klient;
    }

    public void setKlient(KlientOB aKlient) {
        klient = aKlient;
    }
}
