package eu.programisci.relacje.ob;

import javax.persistence.*;

@Entity
@Table(name = "subskrypcje")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_subskrypcje_id")
public class SubskrypcjaOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "nazwa")
    private String nazwa;

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
}
