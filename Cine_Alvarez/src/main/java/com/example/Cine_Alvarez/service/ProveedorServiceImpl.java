package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Proveedor;
import com.example.Cine_Alvarez.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor findById(int id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado: " + id));
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void deleteById(int id) {
        proveedorRepository.deleteById(id);
    }
}