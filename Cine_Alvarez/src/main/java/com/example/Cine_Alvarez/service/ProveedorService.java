package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Proveedor;

import java.util.List;

public interface ProveedorService {
    /**
     * Devuelve todos los proveedores registrados.
     * @return lista de proveedores
     */
    List<Proveedor> findAll();

    /**
     * Busca un proveedor por su id.
     * @param id identificador del proveedor
     * @return el proveedor encontrado o null si no existe
     */
    Proveedor findById(int id);

    /**
     * Guarda o actualiza un proveedor.
     * @param proveedor el proveedor a guardar
     * @return el proveedor guardado con su id generado
     */
    Proveedor save(Proveedor proveedor);

    /**
     * Elimina un proveedor por su id.
     * @param id identificador del proveedor a eliminar
     */
    void deleteById(int id);
}