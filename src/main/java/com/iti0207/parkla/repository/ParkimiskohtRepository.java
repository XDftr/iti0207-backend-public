package com.iti0207.parkla.repository;

import com.iti0207.parkla.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class ParkimiskohtRepository {

    private final EntityManager entityManager;

    public Object lopetaParkimiskoht(Integer id) {
        return entityManager
                .createNativeQuery("SELECT f_lopeta_parkimiskoht(:id)")
                .setParameter("id", id)
                .getSingleResult();
    }

    public List getAktiivsedMitteaktiivsedParkimiskohad() {
        return entityManager
                .createNativeQuery("SELECT * FROM aktiivsed_mitteaktiivsed_parkimiskohad",
                        AktiivsedMitteaktiivsedParkimiskohad.class)
                .getResultList();
    }

    public List getAllParkimiskoht() {
        return entityManager
                .createNativeQuery("SELECT * FROM koik_parkimiskohad",
                        KoikParkimiskohad.class)
                .getResultList();
    }

    public Object getParkimiskohtDetailid(Integer id) {
        return entityManager
                .createNativeQuery("SELECT * FROM parkimiskohtade_detailid d " +
                        "WHERE d.parkimiskoha_kood = :parkimiskoha_kood", ParkimiskohtadeDetailid.class)
                .setParameter("parkimiskoha_kood", id)
                .getSingleResult();
    }

    public List getParkimisKohtadeKoondaruanne() {
        return entityManager
                .createNativeQuery("SELECT * FROM parkimiskohtade_koondaruanne",
                        ParkimiskohtadeKoondaruanne.class)
                .getResultList();
    }

    public List getParkimiskohtadeKategooriad(Integer id) {
        return entityManager
                .createNativeQuery("SELECT * FROM parkimiskohtade_kategooriad pk " +
                        "WHERE pk.parkimiskoha_kood = :parkimiskoha_kood", ParkimiskohtadeKategooriad.class)
                .setParameter("parkimiskoha_kood", id)
                .getResultList();
    }
}
