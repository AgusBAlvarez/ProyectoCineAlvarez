package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Compra;
import java.util.List;

public interface CompraService {
    /**
     * Devuelve todas las compras registradas.
     * @return lista de compras
     */
    List<Compra> findAll();

    /**
     * Busca una compra por su id.
     * @param id identificador de la compra
     * @return la compra encontrada o null si no existe
     */
    Compra findById(Integer id);

    /**
     * Crea una compra y la asocia al cine indicado.
     * @param compra la compra a guardar
     * @param cineId id del cine al que pertenece la compra
     * @return la compra guardada
     */
    Compra save(Compra compra, Integer cineId);

    /**
     * Elimina una compra por su id.
     * @param id identificador de la compra a eliminar
     */
    void deleteById(Integer id);

    /**
     * Agrega un insumo a una compra existente.
     * @param compraId id de la compra
     * @param insumoId id del insumo a agregar
     */
    void agregarInsumo(Integer compraId, Integer insumoId);

    /**
     * Agrega un proveedor a una compra existente.
     * @param compraId id de la compra
     * @param proveedorId id del proveedor a agregar
     */
    void agregarProveedor(Integer compraId, Integer proveedorId);
}