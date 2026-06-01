package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Insumo;
import com.example.Cine_Alvarez.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsumoServiceImpl implements InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    @Override
    public List<Insumo> findAll() {
        return insumoRepository.findAll();
    }

    @Override
    public Insumo findById(int id) {
        return insumoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insumo no encontrado: " + id));
    }

    @Override
    public Insumo save(Insumo insumo) {
        return insumoRepository.save(insumo);
    }

    @Override
    public void deleteById(int id) {
        insumoRepository.deleteById(id);
    }
}