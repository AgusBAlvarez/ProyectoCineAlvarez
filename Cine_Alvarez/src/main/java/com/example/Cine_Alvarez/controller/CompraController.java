package com.example.Cine_Alvarez.controller;

import com.example.Cine_Alvarez.dto.CompraDTO;
import com.example.Cine_Alvarez.entity.Compra;
import com.example.Cine_Alvarez.mapper.CompraMapper;
import com.example.Cine_Alvarez.service.CineService;
import com.example.Cine_Alvarez.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private CompraMapper compraMapper;

    @GetMapping
    public List<CompraDTO> findAll() {
        return compraService.findAll()
                .stream()
                .map(compraMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(compraMapper.toDTO(compraService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CompraDTO> save(@RequestBody Map<String, Object> body) {
        Integer cineId = (Integer) body.get("cineId");
        Compra compra = new Compra();
        compra.setFecha(new Date());
        return ResponseEntity.ok(compraMapper.toDTO(compraService.save(compra, cineId)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        compraService.deleteById(id);
    }

    @PostMapping("/{id}/insumos")
    public ResponseEntity<CompraDTO> agregarInsumo(@PathVariable Integer id, @RequestBody Map<String, Integer> body) {
        compraService.agregarInsumo(id, body.get("insumoId"));
        return ResponseEntity.ok(compraMapper.toDTO(compraService.findById(id)));
    }

    @PostMapping("/{id}/proveedores")
    public ResponseEntity<CompraDTO> agregarProveedor(@PathVariable Integer id, @RequestBody Map<String, Integer> body) {
        compraService.agregarProveedor(id, body.get("proveedorId"));
        return ResponseEntity.ok(compraMapper.toDTO(compraService.findById(id)));
    }
}