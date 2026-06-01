package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Entrada;
import java.util.List;

public interface EntradaService {
    /**
     * Devuelve todas las entradas registradas.
     * @return lista de entradas
     */
    List<Entrada> findAll();

    /**
     * Busca una entrada por su id.
     * @param id identificador de la entrada
     * @return la entrada encontrada o null si no existe
     */
    Entrada findById(int id);

    /**
     * Guarda o actualiza una entrada.
     * @param entrada la entrada a guardar
     * @return la entrada guardada con su id generado
     */
    Entrada save(Entrada entrada);

    /**
     * Elimina una entrada por su id.
     * @param id identificador de la entrada a eliminar
     */
    void deleteById(int id);

    /**
     * Actualiza el asiento y precio de una entrada existente.
     * @param id id de la entrada
     * @param entrada datos nuevos
     * @return entrada actualizada
     */
    Entrada update(int id, Entrada entrada);
}