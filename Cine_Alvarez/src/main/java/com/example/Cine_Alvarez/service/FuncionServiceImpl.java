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
        Sala sala = salaService.findById(salaId);
        generarEntradas(guardada, sala.getCapacidad());
        // asociar la función a la sala
        sala.getFunciones().add(guardada);
        salaService.save(sala);
        return funcionRepository.findById(guardada.getId()).orElse(guardada);
    }

    /**
     * Genera entradas automáticamente para una función según la capacidad de la sala.
     * Los asientos se nombran con letras de fila y número de columna (A1, A2... B1, B2...).
     * @param funcion la función a la que se le generan entradas
     * @param capacidad cantidad de asientos a generar
     */
    private void generarEntradas(Funcion funcion, int capacidad) {
        int columnas = 10;
        for (int i = 0; i < capacidad; i++) {
            char fila = (char) ('A' + (i / columnas));
            int columna = (i % columnas) + 1;
            Entrada entrada = new Entrada();
            entrada.setAsiento(fila + "" + columna);
            entrada.setPrecio(1500);
            Entrada guardada = entradaService.save(entrada);
            funcion.getEntradas().add(guardada);
        }
        funcionRepository.save(funcion);
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

    @Override
    public List<Integer> getEntradasOcupadas(Integer funcionId) {
        return ventaRepository.findAll().stream()
                .filter(v -> v.getFunciones().stream()
                        .anyMatch(f -> f.getId().equals(funcionId)))
                .flatMap(v -> v.getFunciones().stream()
                        .filter(f -> f.getId().equals(funcionId))
                        .flatMap(f -> f.getEntradas().stream()))
                .map(e -> e.getId())
                .distinct()
                .toList();
    }
}