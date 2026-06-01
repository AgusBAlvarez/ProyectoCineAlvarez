package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Cliente;
import java.util.List;

public interface ClienteService {
    /**
     * Devuelve todos los clientes registrados.
     * @return lista de clientes
     */
    List<Cliente> findAll();

    /**
     * Busca un cliente por su id.
     * @param id identificador del cliente
     * @return el cliente encontrado o null si no existe
     */
    Cliente findById(int id);

    /**
     * Guarda o actualiza un cliente.
     * @param cliente el cliente a guardar
     * @return el cliente guardado con su id generado
     */
    Cliente save(Cliente cliente);

    /**
     * Elimina un cliente por su id.
     * @param id identificador del cliente a eliminar
     */
    void deleteById(int id);

    /**
     * Actualiza los datos de un cliente existente.
     * @param id id del cliente
     * @param cliente datos nuevos
     * @return cliente actualizado
     */
    Cliente update(int id, Cliente cliente);
}