package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Funcion;

import java.util.List;

public interface FuncionService {
    /**
     * Devuelve todas las funciones registradas.
     * @return lista de funciones
     */
    List<Funcion> findAll();

    /**
     * Busca una función por su id.
     * @param id identificador de la función
     * @return la función encontrada o null si no existe
     */
    Funcion findById(Integer id);

    /**
     * Guarda una función y genera automáticamente las entradas según la capacidad de la sala.
     * @param funcion la función a guardar
     * @param salaId id de la sala donde se proyecta
     * @return la función guardada con sus entradas generadas
     */
    Funcion save(Funcion funcion, Integer salaId);

    /**
     * Elimina una función por su id.
     * @param id identificador de la función a eliminar
     */
    void deleteById(Integer id);

    /**
     * Asocia una entrada existente a una función.
     * @param funcionId id de la función
     * @param entradaId id de la entrada a asociar
     */
    void agregarEntrada(Integer funcionId, Integer entradaId);

    /**
     * Devuelve los ids de entradas ya vendidas para una función.
     * @param funcionId id de la función
     * @return lista de ids de entradas ocupadas
     */
    List<Integer> getEntradasOcupadas(Integer funcionId);
}