package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Cine;
import com.example.Cine_Alvarez.repository.CineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CineServiceImpl implements CineService {

    @Autowired
    private CineRepository cineRepository;

    @Override
    public List<Cine> findAll() {
        return cineRepository.findAll();
    }

    @Override
    public Cine findById(int id) {
        return cineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cine no encontrado: " + id));
    }

    @Override
    public Cine save(Cine cine) {
        return cineRepository.save(cine);
    }

    @Override
    public void deleteById(int id) {
        cineRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Cine findByEmpleadoId(Integer empleadoId) {
        return cineRepository.findByEmpleadosId(empleadoId);
    }
}