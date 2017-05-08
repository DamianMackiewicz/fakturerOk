package eu.programisci.app.towar.ob;

import eu.programisci.app.towar.enums.EJednostkaMiary;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by student on 08.05.17.
 */

@Entity
@Table(name = "towary")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_towary_id")
public class TowarOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "data_utworzenia", columnDefinition = "TIMESTAMP")
    private Date dataUtworzenia;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "pkwiu")
    private String pkwiu;

    @Column(name = "jednostkaMiary")
    private EJednostkaMiary jednostkaMiary;

    @Column(name = "vat")
    private Integer vat;

    @Column(name = "cenaNetto")
    private Double cenaNetto;

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
