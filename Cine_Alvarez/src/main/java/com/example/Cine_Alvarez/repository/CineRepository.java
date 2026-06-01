package com.example.Cine_Alvarez.repository;

import com.example.Cine_Alvarez.entity.Cine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CineRepository extends JpaRepository<Cine, Integer> {

    /**
     * Busca el cine al que pertenece un empleado.
     * @param empleadoId id del empleado
     * @return el cine asociado a ese empleado
     */
    Cine findByEmpleadosId(Integer empleadoId);
}