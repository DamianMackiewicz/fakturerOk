package eu.programisci.relacje.ob;

import javax.persistence.*;

@Entity
@Table(name = "telefony")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_telefony_id")
public class TelefonOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "numer")
    private String numer;

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String aNumer) {
        numer = aNumer;
    }
}
