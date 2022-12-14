package com.iti0207.parkla.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "parkimiskohtade_kategooriad", schema = "public", catalog = "t206505")
public class ParkimiskohtadeKategooriad {
    @Basic
    @Column(name = "parkimiskoha_kood")
    private Integer parkimiskohaKood;

    @Id
    @Basic
    @Column(name = "parkimiskoha_kategooria")
    private String parkimiskohaKategooria;
    @Basic

    @Column(name = "parkimiskoha_kategooria_tyyp")
    private String parkimiskohaKategooriaTyyp;
}
