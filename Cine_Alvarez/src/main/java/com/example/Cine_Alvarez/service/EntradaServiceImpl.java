package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Entrada;
import com.example.Cine_Alvarez.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntradaServiceImpl implements EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Override
    public List<Entrada> findAll() {
        return entradaRepository.findAll();
    }

    @Override
    public Entrada findById(int id) {
        return entradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrada no encontrada: " + id));
    }

    @Override
    public Entrada save(Entrada entrada) {
        return entradaRepository.save(entrada);
    }

    @Override
    public void deleteById(int id) {
        entradaRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entrada update(int id, Entrada entrada) {
        Entrada existente = entradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrada no encontrada: " + id));
        existente.setAsiento(entrada.getAsiento());
        existente.setPrecio(entrada.getPrecio());
        return entradaRepository.save(existente);
    }
}