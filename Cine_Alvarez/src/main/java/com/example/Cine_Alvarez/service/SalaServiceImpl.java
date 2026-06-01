package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Sala;
import com.example.Cine_Alvarez.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalaServiceImpl implements SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public List<Sala> findAll() {
        return salaRepository.findAll();
    }

    @Override
    public Sala findById(int id) {
        return salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala no encontrada: " + id));
    }

    @Override
    public Sala save(Sala sala) {
        return salaRepository.save(sala);
    }

    @Override
    public void deleteById(int id) {
        salaRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sala update(int id, int capacidad) {
        Sala existente = salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala no encontrada: " + id));
        existente.setCapacidad(capacidad);
        return salaRepository.save(existente);
    }
}