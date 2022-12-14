package com.iti0207.parkla.controller;

import com.iti0207.parkla.service.ParkimiskohtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/private/parkimiskoht")
public class ParkimiskohtController {
    private final ParkimiskohtService parkimiskohtService;

    public ParkimiskohtController(ParkimiskohtService parkimiskohtService) {
        this.parkimiskohtService = parkimiskohtService;
    }

    @GetMapping("leia_koik")
    public List getAllParkimiskoht() {
        return parkimiskohtService.getAllParkimiskoht();
    }

    @GetMapping("detailid/{id}")
    public Object getParkimiskohtDetailid(@PathVariable Integer id) {
        return parkimiskohtService.getParkimiskohtadeKoikDetailid(id);
    }

    @GetMapping("leia_aktiivsed_mitteaktiivsed")
    public List getAktiivsedMitteaktiivsedParkimiskohad() {
        return parkimiskohtService.getAktiivsedMitteaktiivsedParkimiskohad();
    }

    @GetMapping("leia_koondaruanne")
    public List getParkimiskohtadeKoondaruanne() {
        return parkimiskohtService.getParkimiskohtadeKoondaruanne();
    }

    @PutMapping("lopeta/{id}")
    public ResponseEntity<String> lopetaParkimiskoht(@PathVariable Integer id) {
        Object kood = parkimiskohtService.lopetaParkimiskoht(id);
        return new ResponseEntity<>("Parkimiskoht " + kood + " on lõpetatud", HttpStatus.OK);
    }
    @GetMapping("kategooriad/{id}")
    public List getParkimiskohtadeKategooriad(@PathVariable Integer id) {
        return parkimiskohtService.getParkimiskohtadeKategooriad(id);
    }
}
