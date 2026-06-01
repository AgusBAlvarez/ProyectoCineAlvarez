package com.example.Cine_Alvarez.controller;

import com.example.Cine_Alvarez.dto.EntradaDTO;
import com.example.Cine_Alvarez.dto.FuncionDTO;
import com.example.Cine_Alvarez.dto.FuncionRequestDTO;
import com.example.Cine_Alvarez.entity.Funcion;
import com.example.Cine_Alvarez.mapper.FuncionMapper;
import com.example.Cine_Alvarez.service.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funciones")
public class FuncionController {

    @Autowired
    private FuncionService funcionService;

    @Autowired
    private FuncionMapper funcionMapper;

    @GetMapping
    public List<FuncionDTO> findAll() {
        return funcionService.findAll()
                .stream()
                .map(funcionMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(funcionMapper.toDTO(funcionService.findById(id)));
    }

    /**
     * Crea una nueva función con su sala y película asociadas.
     * Genera automáticamente las entradas según la capacidad de la sala.
     * @param body datos de la función a crear
     * @return función creada como DTO
     */
    @PostMapping
    public ResponseEntity<FuncionDTO> save(@RequestBody FuncionRequestDTO body) {
        Funcion funcion = new Funcion();
        funcion.setHorario(java.time.LocalTime.parse(body.getHorario()));
        com.example.Cine_Alvarez.entity.Pelicula pelicula = new com.example.Cine_Alvarez.entity.Pelicula();
        pelicula.setId(body.getPeliculaId());
        funcion.setPeliculas(pelicula);
        return ResponseEntity.ok(funcionMapper.toDTO(funcionService.save(funcion, body.getSalaId())));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        funcionService.deleteById(id);
    }

    /**
     * Devuelve las entradas asociadas a una función.
     * @param id id de la función
     * @return lista de entradas de esa función
     */
    @GetMapping("/{id}/entradas")
    public ResponseEntity<List<EntradaDTO>> getEntradas(@PathVariable Integer id) {
        Funcion funcion = funcionService.findById(id);
        List<EntradaDTO> entradas = funcion.getEntradas()
                .stream()
                .map(e -> new EntradaDTO(e.getId(), e.getAsiento(), e.getPrecio(), id))
                .toList();
        return ResponseEntity.ok(entradas);
    }

    @PostMapping("/{id}/entradas")
    public ResponseEntity<FuncionDTO> agregarEntrada(
            @PathVariable Integer id,
            @RequestBody Map<String, Integer> body) {
        funcionService.agregarEntrada(id, body.get("entradaId"));
        return ResponseEntity.ok(funcionMapper.toDTO(funcionService.findById(id)));
    }

    /**
     * Devuelve los ids de entradas ya vendidas para una función.
     * @param id id de la función
     * @return lista de ids ocupados
     */
    @GetMapping("/{id}/entradas-ocupadas")
    public ResponseEntity<List<Integer>> getEntradasOcupadas(@PathVariable Integer id) {
        return ResponseEntity.ok(funcionService.getEntradasOcupadas(id));
    }
}