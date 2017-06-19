package eu.programisci.relacje.ob;

import javax.persistence.*;

@Entity
@Table(name = "konta")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_konta_id")
public class KontoOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "haslo")
    private String haslo;

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
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
