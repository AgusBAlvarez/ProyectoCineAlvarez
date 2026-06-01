package com.example.Cine_Alvarez.controller;

import com.example.Cine_Alvarez.dto.EntradaDTO;
import com.example.Cine_Alvarez.entity.Entrada;
import com.example.Cine_Alvarez.mapper.EntradaMapper;
import com.example.Cine_Alvarez.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @Autowired
    private EntradaMapper entradaMapper;

    @GetMapping
    public List<EntradaDTO> findAll() {
        return entradaService.findAll()
                .stream()
                .map(entradaMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(entradaMapper.toDTO(entradaService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<EntradaDTO> save(@RequestBody Entrada entrada) {
        return ResponseEntity.ok(entradaMapper.toDTO(entradaService.save(entrada)));
    }

    /**
     * Actualiza el asiento y precio de una entrada existente.
     * @param id id de la entrada
     * @param entrada datos nuevos
     * @return entrada actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<EntradaDTO> update(@PathVariable Integer id, @RequestBody Entrada entrada) {
        return ResponseEntity.ok(entradaMapper.toDTO(entradaService.update(id, entrada)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        entradaService.deleteById(id);
    }
}