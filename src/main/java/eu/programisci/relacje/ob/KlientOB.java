package eu.programisci.relacje.ob;

import eu.programisci.relacje.enums.ECechaKlienta;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "klienci")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_klienci_id")
public class KlientOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    // jeden uzytkownik posiada jedno konto, a do jednego konta jest pzrypisany jeden uzytkownik
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "konto_id")
    private KontoOB konto;

    // jeden uzytkownik moze miec wiele subskrypcji, ale kazda subskrypcja nalezy do jednego uzytkownika
    // jest to przyklad prawdziwej relacji @OneToMany, dla ktorej powstaje tabela relacyjna
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "klienci_subskrypcje")
    private Set<SubskrypcjaOB> subskrypcje;

    // jeden uzytkownik moze miec wiele telefonow, ale kazdy telefon nalezy do jednego uzytkownika
    // jest to przyklad relacji, ktora jest typu @OneToMany tylko z punktu widzenia uzytkownika JPA
    // po stronie bazy danych jest zrealizowana jako relacja @ManyToOne z kolumna relacyjna KLIENT w tabeli TELEFONY
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "klient_id")
    private Set<TelefonOB> telefony;

    // jeden klient moze miec wiele adresow, a pod kazdym adresem moze mieszkac wielu klientow
    // relacje @ManyToMany moga istniec tylko w formie tabeli relacyjnej
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "klienci_adresy", joinColumns = {
            @JoinColumn(name = "klient_id")},
            inverseJoinColumns = {@JoinColumn(name = "adres_id")})
    private Set<AdresOB> adresy;

    // jeden klient moze miec wiele cech, cecha nie moze miec nic, poniewaz nie jest encja
    // jest to przyklad utworzenia pseudo-relacji (slownika), zamiast wiazania z inna encja jest tworzone wiazanie z przekazanymi wartosciami
    // najczesciej stosowane w przypadku enumow, tworzona jest tabela pseudo-relacyjna, z jednej strony id, z drugiej wartosc
    @ElementCollection(targetClass = ECechaKlienta.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @Column(name = "cecha")
    @CollectionTable(name = "klienci_cechy", joinColumns = @JoinColumn(name = "klient_id"))
    private Set<ECechaKlienta> cechyKlienta = new HashSet<>();


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

    public KontoOB getKonto() {
        return konto;
    }

    public void setKonto(KontoOB aKonto) {
        konto = aKonto;
    }

    public Set<SubskrypcjaOB> getSubskrypcje() {
        return subskrypcje;
    }

    public void setSubskrypcje(Set<SubskrypcjaOB> aSubskrypcje) {
        subskrypcje = aSubskrypcje;
    }

    public Set<TelefonOB> getTelefony() {
        return telefony;
    }

    public void setTelefony(Set<TelefonOB> aTelefony) {
        telefony = aTelefony;
    }

    public Set<AdresOB> getAdresy() {
        return adresy;
    }

    public void setAdresy(Set<AdresOB> aAdresy) {
        adresy = aAdresy;
    }

    public Set<ECechaKlienta> getCechyKlienta() {
        return cechyKlienta;
    }

    public void setCechyKlienta(Set<ECechaKlienta> aCechyKlienta) {
        cechyKlienta = aCechyKlienta;
    }
}
