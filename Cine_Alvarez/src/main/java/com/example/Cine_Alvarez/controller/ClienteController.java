package com.example.Cine_Alvarez.controller;

import com.example.Cine_Alvarez.dto.ClienteDTO;
import com.example.Cine_Alvarez.entity.Cliente;
import com.example.Cine_Alvarez.mapper.ClienteMapper;
import com.example.Cine_Alvarez.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper clienteMapper;

    @GetMapping
    public List<ClienteDTO> findAll() {
        return clienteService.findAll()
                .stream()
                .map(clienteMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable int id) {
        return ResponseEntity.ok(clienteMapper.toDTO(clienteService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteMapper.toDTO(clienteService.save(cliente)));
    }

    /**
     * Actualiza los datos de un cliente existente.
     * @param id id del cliente
     * @param cliente datos nuevos
     * @return cliente actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable int id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteMapper.toDTO(clienteService.update(id, cliente)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        clienteService.deleteById(id);
    }
}