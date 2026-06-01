package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Entrada;
import com.example.Cine_Alvarez.entity.Funcion;
import com.example.Cine_Alvarez.entity.Sala;
import com.example.Cine_Alvarez.repository.FuncionRepository;
import com.example.Cine_Alvarez.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionServiceImpl implements FuncionService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private FuncionRepository funcionRepository;

    @Autowired
    private EntradaService entradaService;

    @Autowired
    private SalaService salaService;

    @Override
    public List<Funcion> findAll() {
        return funcionRepository.findAll();
    }

    @Override
    public Funcion findById(Integer id) {
        return funcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcion no encontrada: " + id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Funcion save(Funcion funcion, Integer salaId) {
        Funcion guardada = funcionRepository.save(funcion);
        if (salaId != null) {
            Sala sala = salaService.findById(salaId);
            sala.getFunciones().add(guardada);
            salaService.save(sala);
        }
        return funcionRepository.findById(guardada.getId()).orElse(guardada);
    }

    @Override
    public void deleteById(Integer id) {
        funcionRepository.deleteById(id);
    }

    @Override
    public void agregarEntrada(Integer funcionId, Integer entradaId) {
        Funcion funcion = funcionRepository.findById(funcionId)
                .orElseThrow(() -> new RuntimeException("Funcion no encontrada: " + funcionId));
        Entrada entrada = entradaService.findById(entradaId);
        funcion.getEntradas().add(entrada);
        funcionRepository.save(funcion);
    }

//    @Override
//    public List<Integer> getEntradasOcupadas(Integer funcionId) {
//        return ventaRepository.findAll().stream()
//                .filter(v -> v.getFunciones().stream()
//                        .anyMatch(f -> f.getId().equals(funcionId)))
//                .flatMap(v -> v.getFunciones().stream()
//                        .filter(f -> f.getId().equals(funcionId))
//                        .flatMap(f -> f.getEntradas().stream()))
//                .map(Entrada::getId)
//                .distinct()
//                .toList();
//    }
}