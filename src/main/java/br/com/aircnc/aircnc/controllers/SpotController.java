package br.com.aircnc.aircnc.controllers;

import br.com.aircnc.aircnc.dtos.SpotDTO;
import br.com.aircnc.aircnc.services.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/spots")
public class SpotController {
    @Autowired
    private SpotService service;
    @PostMapping
    public ResponseEntity<SpotDTO> create(@RequestBody  SpotDTO dto){
        SpotDTO spot = service.insert(dto);
        return ResponseEntity.ok().body(spot);
    }
}
