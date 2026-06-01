package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Insumo;

import java.util.List;

public interface InsumoService {
    /**
     * Devuelve todos los insumos registrados.
     * @return lista de insumos
     */
    List<Insumo> findAll();

    /**
     * Busca un insumo por su id.
     * @param id identificador del insumo
     * @return el insumo encontrado o null si no existe
     */
    Insumo findById(int id);

    /**
     * Guarda o actualiza un insumo.
     * @param insumo el insumo a guardar
     * @return el insumo guardado con su id generado
     */
    Insumo save(Insumo insumo);

    /**
     * Elimina un insumo por su id.
     * @param id identificador del insumo a eliminar
     */
    void deleteById(int id);
}