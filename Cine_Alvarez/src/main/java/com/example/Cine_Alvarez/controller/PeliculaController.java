package com.example.Cine_Alvarez.controller;

import com.example.Cine_Alvarez.dto.PeliculaDTO;
import com.example.Cine_Alvarez.entity.Pelicula;
import com.example.Cine_Alvarez.mapper.PeliculaMapper;
import com.example.Cine_Alvarez.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private PeliculaMapper peliculaMapper;

    @GetMapping
    public List<PeliculaDTO> findAll() {
        return peliculaService.findAll()
                .stream()
                .map(peliculaMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(peliculaMapper.toDTO(peliculaService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody Pelicula pelicula) {
        return ResponseEntity.ok(peliculaMapper.toDTO(peliculaService.save(pelicula)));
    }

    /**
     * Actualiza el título y género de una película existente.
     * @param id id de la película
     * @param pelicula datos nuevos
     * @return película actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> update(@PathVariable Integer id, @RequestBody Pelicula pelicula) {
        return ResponseEntity.ok(peliculaMapper.toDTO(peliculaService.update(id, pelicula)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        peliculaService.deleteById(id);
    }
}