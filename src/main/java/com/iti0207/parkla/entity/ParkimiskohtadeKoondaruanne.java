package com.iti0207.parkla.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "parkimiskohtade_koondaruanne", schema = "public", catalog = "t206505")
public class ParkimiskohtadeKoondaruanne {
    @Id
    @Basic
    @Column(name = "parkimiskoha_seisundi_liik_kood")
    private Short parkimiskohaSeisundiLiikKood;
    @Basic
    @Column(name = "seisundi_nimetus", length = -1)
    private String seisundiNimetus;
    @Basic
    @Column(name = "arv")
    private Long arv;
}
