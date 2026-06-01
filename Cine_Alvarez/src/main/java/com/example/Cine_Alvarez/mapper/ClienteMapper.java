package com.example.Cine_Alvarez.mapper;

import com.example.Cine_Alvarez.dto.ClienteDTO;
import com.example.Cine_Alvarez.entity.Cliente;
import com.example.Cine_Alvarez.entity.ClienteVIP;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    /**
     * Convierte una entidad Cliente o ClienteVIP a ClienteDTO.
     * @param c entidad cliente
     * @return DTO con los datos del cliente
     */
    public ClienteDTO toDTO(Cliente c) {
        if (c instanceof ClienteVIP vip) {
            return new ClienteDTO(c.getId(), c.getNombre(), c.getEmail(), true, vip.getDescuento());
        }
        return new ClienteDTO(c.getId(), c.getNombre(), c.getEmail(), false, 0);
    }
}
