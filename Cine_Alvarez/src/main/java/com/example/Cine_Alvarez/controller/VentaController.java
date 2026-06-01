package com.example.Cine_Alvarez.controller;

import com.example.Cine_Alvarez.dto.VentaDTO;
import com.example.Cine_Alvarez.entity.Venta;
import com.example.Cine_Alvarez.mapper.VentaMapper;
import com.example.Cine_Alvarez.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private VentaMapper ventaMapper;

    @GetMapping
    public List<VentaDTO> findAll() {
        return ventaService.findAll()
                .stream()
                .map(ventaMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(ventaMapper.toDTO(ventaService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<VentaDTO> save(@RequestBody Map<String, Object> body) {
        Integer pagoId = (Integer) ((Map<String, Object>) body.get("pago")).get("id");
        Integer cineId = (Integer) body.get("cineId");
        return ResponseEntity.ok(ventaMapper.toDTO(ventaService.save(pagoId, cineId)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        ventaService.deleteById(id);
    }

    @PostMapping("/{id}/funciones")
    public ResponseEntity<VentaDTO> agregarFuncion(@PathVariable Integer id, @RequestBody Map<String, Integer> body) {
        ventaService.agregarFuncion(id, body.get("funcionId"));
        return ResponseEntity.ok(ventaMapper.toDTO(ventaService.findById(id)));
    }

    @PostMapping("/{id}/clientes")
    public ResponseEntity<VentaDTO> agregarCliente(@PathVariable Integer id, @RequestBody Map<String, Integer> body) {
        ventaService.agregarCliente(id, body.get("clienteId"));
        return ResponseEntity.ok(ventaMapper.toDTO(ventaService.findById(id)));
    }

}