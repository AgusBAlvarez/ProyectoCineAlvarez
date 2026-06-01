package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.dto.EmpleadoDTO;
import com.example.Cine_Alvarez.entity.Empleado;
import com.example.Cine_Alvarez.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado findById(int id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado: " + id));
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void deleteById(int id) {
        empleadoRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Empleado update(int id, EmpleadoDTO dto) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado: " + id));
        empleado.setNombre(dto.getNombre());
        empleado.setDni(dto.getDni());
        return empleadoRepository.save(empleado);
    }
}