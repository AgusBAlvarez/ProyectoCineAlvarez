package com.example.Cine_Alvarez.controller;

import com.example.Cine_Alvarez.dto.SalaDTO;
import com.example.Cine_Alvarez.entity.Sala;
import com.example.Cine_Alvarez.mapper.SalaMapper;
import com.example.Cine_Alvarez.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @Autowired
    private SalaMapper salaMapper;

    @GetMapping
    public List<SalaDTO> findAll() {
        return salaService.findAll()
                .stream()
                .map(salaMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(salaMapper.toDTO(salaService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<SalaDTO> save(@RequestBody Sala sala) {
        return ResponseEntity.ok(salaMapper.toDTO(salaService.save(sala)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        salaService.deleteById(id);
    }

    /**
     * Actualiza la capacidad de una sala existente.
     * @param id id de la sala
     * @param body mapa con la nueva capacidad
     * @return sala actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<SalaDTO> update(@PathVariable Integer id, @RequestBody Map<String, Integer> body) {
        return ResponseEntity.ok(salaMapper.toDTO(salaService.update(id, body.get("capacidad"))));
    }
}