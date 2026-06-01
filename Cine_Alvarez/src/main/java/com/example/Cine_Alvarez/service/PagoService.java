package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Pago;

import java.util.List;

public interface PagoService {
    /**
     * Devuelve todos los pagos registrados.
     * @return lista de pagos
     */
    List<Pago> findAll();

    /**
     * Busca un pago por su id.
     * @param id identificador del pago
     * @return el pago encontrado o null si no existe
     */
    Pago findById(int id);

    /**
     * Guarda o actualiza un pago.
     * @param pago el pago a guardar
     * @return el pago guardado con su id generado
     */
    Pago save(Pago pago);

    /**
     * Elimina un pago por su id.
     * @param id identificador del pago a eliminar
     */
    void deleteById(int id);
}