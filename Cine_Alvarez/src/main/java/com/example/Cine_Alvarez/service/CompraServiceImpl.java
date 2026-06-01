package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.*;
import com.example.Cine_Alvarez.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CineService cineService;

    @Autowired
    private InsumoService insumoService;

    @Autowired
    private ProveedorService proveedorService;

    @Override
    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    @Override
    public Compra findById(Integer id) {
        return compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada: " + id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Compra save(Compra compra, Integer cineId) {
        Compra guardada = compraRepository.save(compra);
        Cine cine = cineService.findById(cineId);
        cine.getCompras().add(guardada);
        cineService.save(cine);
        return compraRepository.findById(guardada.getId()).orElse(guardada);
    }

    @Override
    public void deleteById(Integer id) {
        compraRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarInsumo(Integer compraId, Integer insumoId) {
        Compra compra = compraRepository.findById(compraId)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada: " + compraId));
        Insumo insumo = insumoService.findById(insumoId);
        compra.getInsumos().add(insumo);
        compraRepository.save(compra);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarProveedor(Integer compraId, Integer proveedorId) {
        Compra compra = compraRepository.findById(compraId)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada: " + compraId));
        Proveedor proveedor = proveedorService.findById(proveedorId);
        compra.getProveedores().add(proveedor);
        compraRepository.save(compra);
    }
}