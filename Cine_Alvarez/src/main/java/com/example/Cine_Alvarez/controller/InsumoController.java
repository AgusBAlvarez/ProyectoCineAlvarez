package com.example.Cine_Alvarez.controller;

import com.example.Cine_Alvarez.dto.InsumoDTO;
import com.example.Cine_Alvarez.entity.Insumo;
import com.example.Cine_Alvarez.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insumos")
public class InsumoController {

    @Autowired
    private InsumoService insumoService;

    @GetMapping
    public List<InsumoDTO> findAll() {
        return insumoService.findAll()
                .stream()
                .map(i -> new InsumoDTO(i.getId(), i.getNombre(), i.getPrecio()))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsumoDTO> findById(@PathVariable Integer id) {
        Insumo i = insumoService.findById(id);
        return ResponseEntity.ok(new InsumoDTO(i.getId(), i.getNombre(), i.getPrecio()));
    }

    @PostMapping
    public ResponseEntity<InsumoDTO> save(@RequestBody Insumo insumo) {
        Insumo guardado = insumoService.save(insumo);
        return ResponseEntity.ok(new InsumoDTO(guardado.getId(), guardado.getNombre(), guardado.getPrecio()));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        insumoService.deleteById(id);
    }
}