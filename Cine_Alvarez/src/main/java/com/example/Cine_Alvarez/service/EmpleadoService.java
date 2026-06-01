package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.dto.EmpleadoDTO;
import com.example.Cine_Alvarez.entity.Empleado;

import java.util.List;

public interface EmpleadoService {
    /**
     * Devuelve todos los empleados registrados.
     * @return lista de empleados
     */
    List<Empleado> findAll();

    /**
     * Busca un empleado por su id.
     * @param id identificador del empleado
     * @return el empleado encontrado o null si no existe
     */
    Empleado findById(int id);

    /**
     * Guarda o actualiza un empleado.
     * @param empleado el empleado a guardar
     * @return el empleado guardado con su id generado
     */
    Empleado save(Empleado empleado);

    /**
     * Elimina un empleado por su id.
     * @param id identificador del empleado a eliminar
     */
    void deleteById(int id);

    /**
     * Actualiza el nombre y DNI de un empleado existente.
     * @param id id del empleado
     * @param dto datos nuevos
     * @return empleado actualizado
     */
    Empleado update(int id, EmpleadoDTO dto);
}