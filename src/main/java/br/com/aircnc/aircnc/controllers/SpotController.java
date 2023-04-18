package br.com.aircnc.aircnc.controllers;

import br.com.aircnc.aircnc.dtos.SpotDTO;
import br.com.aircnc.aircnc.services.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

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
   @GetMapping
   public ResponseEntity<List<SpotDTO>> findAllPaged(){
       List<SpotDTO> spots = service.findAll();
       return ResponseEntity.ok().body(spots);
   }
}
