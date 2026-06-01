package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Sala;
import java.util.List;

public interface SalaService {
    /**
     * Devuelve todas las salas registradas.
     * @return lista de salas
     */
    List<Sala> findAll();

    /**
     * Busca una sala por su id.
     * @param id identificador de la sala
     * @return la sala encontrada o null si no existe
     */
    Sala findById(int id);

    /**
     * Guarda o actualiza una sala.
     * @param sala la sala a guardar
     * @return la sala guardada con su id generado
     */
    Sala save(Sala sala);

    /**
     * Elimina una sala por su id.
     * @param id identificador de la sala a eliminar
     */
    void deleteById(int id);

    /**
     * Actualiza la capacidad de una sala existente.
     * @param id id de la sala
     * @param capacidad nueva capacidad
     * @return sala actualizada
     */
    Sala update(int id, int capacidad);
}