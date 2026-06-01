package com.example.Cine_Alvarez.controller;

import com.example.Cine_Alvarez.dto.CineDTO;
import com.example.Cine_Alvarez.entity.Cine;
import com.example.Cine_Alvarez.service.CineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cines")
public class CineController {

    @Autowired
    private CineService cineService;

    @GetMapping
    public List<CineDTO> findAll() {
        return cineService.findAll()
                .stream()
                .map(c -> new CineDTO(c.getId(), c.getNombre(), c.getDireccion()))
                .toList();
    }

    @GetMapping("/{id}")
    public Cine findById(@PathVariable int id) {
        return cineService.findById(id);
    }

    @PostMapping
    public Cine save(@RequestBody Cine cine) {
        return cineService.save(cine);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        cineService.deleteById(id);
    }

    /**
     * Devuelve el cine asociado a un empleado.
     * @param empleadoId id del empleado
     * @return CineDTO del cine encontrado
     */
    @GetMapping("/by-empleado/{empleadoId}")
    public CineDTO findByEmpleado(@PathVariable Integer empleadoId) {
        Cine cine = cineService.findByEmpleadoId(empleadoId);
        return new CineDTO(cine.getId(), cine.getNombre(), cine.getDireccion());
    }
}
