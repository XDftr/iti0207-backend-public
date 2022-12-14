package com.iti0207.parkla.service;

import com.iti0207.parkla.repository.ParkimiskohtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkimiskohtService {
    private final ParkimiskohtRepository parkimiskohtRepository;


    public List getAllParkimiskoht() {

        return parkimiskohtRepository.getAllParkimiskoht();
    }

    public Object getParkimiskohtadeKoikDetailid(Integer id) {
        return parkimiskohtRepository.getParkimiskohtDetailid(id);
    }

    public List getAktiivsedMitteaktiivsedParkimiskohad() {
        return parkimiskohtRepository.getAktiivsedMitteaktiivsedParkimiskohad();
    }

    public List getParkimiskohtadeKoondaruanne() {
        return parkimiskohtRepository.getParkimisKohtadeKoondaruanne();
    }

    public Object lopetaParkimiskoht(Integer id) {
        return parkimiskohtRepository.lopetaParkimiskoht(id);
    }

    public List getParkimiskohtadeKategooriad(Integer id) {
        return parkimiskohtRepository.getParkimiskohtadeKategooriad(id);
    }
}
