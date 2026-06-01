package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Cliente;
import com.example.Cine_Alvarez.entity.ClienteVIP;
import com.example.Cine_Alvarez.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(int id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + id));
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(int id) {
        clienteRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Cliente update(int id, Cliente cliente) {
        Cliente existente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + id));
        existente.setNombre(cliente.getNombre());
        existente.setEmail(cliente.getEmail());
        if (existente instanceof ClienteVIP vip && cliente instanceof ClienteVIP clienteVIP) {
            vip.setDescuento(clienteVIP.getDescuento());
        }
        return clienteRepository.save(existente);
    }
}