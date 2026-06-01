package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Cine;

import java.util.List;

public interface CineService {
    /**
     * Devuelve todos los cines registrados.
     * @return lista de cines
     */
    List<Cine> findAll();

    /**
     * Busca un cine por su id.
     * @param id identificador del cine
     * @return el cine encontrado o null si no existe
     */
    Cine findById(int id);

    /**
     * Guarda o actualiza un cine.
     * @param cine el cine a guardar
     * @return el cine guardado con su id generado
     */
    Cine save(Cine cine);

    /**
     * Elimina un cine por su id.
     * @param id identificador del cine a eliminar
     */
    void deleteById(int id);

    /**
     * Busca el cine al que pertenece un empleado.
     * @param empleadoId id del empleado
     * @return el cine asociado a ese empleado
     */
    Cine findByEmpleadoId(Integer empleadoId);
}