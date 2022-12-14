package com.iti0207.parkla.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "aktiivsed_mitteaktiivsed_parkimiskohad", schema = "public", catalog = "t206505")
public class AktiivsedMitteaktiivsedParkimiskohad {
    @Id
    @Basic
    @Column(name = "parkimiskoha_kood")
    private Integer parkimiskohaKood;
    @Basic
    @Column(name = "pinnakatte")
    private String pinnakatte;
    @Basic
    @Column(name = "hetkeseisund")
    private String hetkeseisund;
    @Basic
    @Column(name = "parkla_kood")
    private Integer parklaKood;
    @Basic
    @Column(name = "koordinaadid_pikkus", precision = 6)
    private BigDecimal koordinaadidPikkus;
    @Basic
    @Column(name = "koordinaadid_laius", precision = 6)
    private BigDecimal koordinaadidLaius;
    @Basic
    @Column(name = "parkimiskoha_kommentaar", length = -1)
    private String parkimiskohaKommentaar;
}
