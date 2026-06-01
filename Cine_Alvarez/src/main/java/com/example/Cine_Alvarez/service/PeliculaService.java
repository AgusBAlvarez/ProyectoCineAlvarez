package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Pelicula;
import java.util.List;

public interface PeliculaService {
    /**
     * Devuelve todas las películas registradas.
     * @return lista de películas
     */
    List<Pelicula> findAll();

    /**
     * Busca una película por su id.
     * @param id identificador de la película
     * @return la película encontrada o null si no existe
     */
    Pelicula findById(int id);

    /**
     * Guarda o actualiza una película.
     * @param pelicula la película a guardar
     * @return la película guardada con su id generado
     */
    Pelicula save(Pelicula pelicula);

    /**
     * Elimina una película por su id.
     * @param id identificador de la película a eliminar
     */
    void deleteById(int id);

    /**
     * Actualiza el título y género de una película existente.
     * @param id id de la película
     * @param pelicula datos nuevos
     * @return película actualizada
     */
    Pelicula update(int id, Pelicula pelicula);
}