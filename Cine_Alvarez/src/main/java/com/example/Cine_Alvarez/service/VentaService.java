package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Venta;

import java.util.List;

public interface VentaService {
    /**
     * Devuelve todas las ventas registradas.
     *
     * @return lista de ventas
     */
    List<Venta> findAll();

    /**
     * Busca una venta por su id.
     *
     * @param id identificador de la venta
     * @return la venta encontrada o null si no existe
     */
    Venta findById(int id);

    /**
     * Crea una venta asociada a un cine, con un pago ya existente.
     *
     * @param pagoId id del pago previamente creado
     * @param cineId id del cine donde se realiza la venta
     * @return la venta creada
     */
    Venta save(Integer pagoId, Integer cineId);

    /**
     * Elimina una venta por su id.
     * @param id identificador de la venta a eliminar
     */
    void deleteById(int id);

    /**
     * Agrega una función a una venta existente.
     * @param ventaId id de la venta
     * @param funcionId id de la función a agregar
     */
    void agregarFuncion(Integer ventaId, Integer funcionId);

    /**
     * Agrega un cliente a una venta existente y aplica descuento si es VIP.
     * @param ventaId id de la venta
     * @param clienteId id del cliente a agregar
     */
    void agregarCliente(Integer ventaId, Integer clienteId);
}