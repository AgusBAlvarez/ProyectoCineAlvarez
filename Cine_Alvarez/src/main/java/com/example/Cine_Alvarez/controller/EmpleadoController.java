package com.example.Cine_Alvarez.controller;

import com.example.Cine_Alvarez.dto.EmpleadoDTO;
import com.example.Cine_Alvarez.entity.Empleado;
import com.example.Cine_Alvarez.mapper.EmpleadoMapper;
import com.example.Cine_Alvarez.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private EmpleadoMapper empleadoMapper;

    @GetMapping
    public List<EmpleadoDTO> findAll() {
        return empleadoService.findAll()
                .stream()
                .map(empleadoMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> findById(@PathVariable int id) {
        return ResponseEntity.ok(empleadoMapper.toDTO(empleadoService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> save(@RequestBody Empleado empleado) {
        return ResponseEntity.ok(empleadoMapper.toDTO(empleadoService.save(empleado)));
    }

    /**
     * Actualiza el nombre y DNI de un empleado existente.
     * @param id id del empleado a actualizar
     * @param dto datos nuevos del empleado
     * @return empleado actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(@PathVariable int id, @RequestBody EmpleadoDTO dto) {
        return ResponseEntity.ok(empleadoMapper.toDTO(empleadoService.update(id, dto)));
    }
}