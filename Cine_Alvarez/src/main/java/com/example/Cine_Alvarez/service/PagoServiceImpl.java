package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Pago;
import com.example.Cine_Alvarez.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService{

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago findById(int id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado: " + id));
    }

    @Override
    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public void deleteById(int id) {
        pagoRepository.deleteById(id);
    }
}