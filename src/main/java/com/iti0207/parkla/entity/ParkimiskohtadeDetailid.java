package com.iti0207.parkla.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "parkimiskohtade_detailid", schema = "public", catalog = "t206505")
public class ParkimiskohtadeDetailid {
    @Id
    @Basic
    @Column(name = "parkimiskoha_kood")
    private Integer parkimiskohaKood;
    @Basic
    @Column(name = "parkla_kood")
    private Integer parklaKood;
    @Basic
    @Column(name = "parkla_nimi", length = 200)
    private String parklaNimi;
    @Basic
    @Column(name = "koordinaadid_pikkus", precision = 6)
    private BigDecimal koordinaadidPikkus;
    @Basic
    @Column(name = "koordinaadid_laius", precision = 6)
    private BigDecimal koordinaadidLaius;
    @Basic
    @Column(name = "parkimiskoha_kommentaar", length = -1)
    private String parkimiskohaKommentaar;
    @Basic
    @Column(name = "pinnakatte")
    private String pinnakatte;
    @Basic
    @Column(name = "parkimiskoha_regaeg")
    private String parkimiskohaRegaeg;
    @Basic
    @Column(name = "registreerija_eesnimi", length = 50)
    private String registreerijaEesnimi;
    @Basic
    @Column(name = "registreerija_perenimi", length = 50)
    private String registreerijaPerenimi;
    @Basic
    @Column(name = "registreerija_e_meil", length = 254)
    private String registreerijaEMeil;
}
