package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.*;
import com.example.Cine_Alvarez.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private CineService cineService;

    @Autowired
    private FuncionService funcionService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PagoService pagoService;

    @Override
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta findById(int id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada: " + id));
    }

    @Override
    public void deleteById(int id) {
        ventaRepository.deleteById(id);
    }

    /**
     * Crea una venta asociada a un cine, con un pago ya existente.
     * @param pagoId id del pago previamente creado
     * @param cineId id del cine donde se realiza la venta
     * @return la venta creada
     */
    @Override
    public Venta save(Integer pagoId, Integer cineId) {
        Pago pago = pagoService.findById(pagoId);
        Venta venta = new Venta();
        venta.setFecha(LocalDate.now());
        venta.setPago(pago);
        Venta guardada = ventaRepository.save(venta);
        Cine cine = cineService.findById(cineId);
        cine.getVentas().add(guardada);
        cineService.save(cine);
        return ventaRepository.findById(guardada.getId()).orElse(guardada);
    }

    /**
     * Agrega una función a una venta existente.
     * @param ventaId id de la venta
     * @param funcionId id de la función a agregar
     */
    @Override
    public void agregarFuncion(Integer ventaId, Integer funcionId) {
        Venta venta = ventaRepository.findById(ventaId)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada: " + ventaId));
        Funcion funcion = funcionService.findById(funcionId);
        venta.getFunciones().add(funcion);
        ventaRepository.save(venta);
    }

    /**
     * Agrega un cliente a una venta existente y aplica descuento si es VIP.
     * @param ventaId id de la venta
     * @param clienteId id del cliente a agregar
     */
    @Override
    public void agregarCliente(Integer ventaId, Integer clienteId) {
        Venta venta = ventaRepository.findById(ventaId)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada: " + ventaId));
        Cliente cliente = clienteService.findById(clienteId);
        venta.getClientes().add(cliente);
        aplicarDescuento(venta, cliente);
        ventaRepository.save(venta);
    }

    /**
     * Aplica el descuento correspondiente al cliente si es VIP,
     * actualizando el monto del pago asociado a la venta.
     * @param venta la venta a procesar
     * @param cliente el cliente de la venta
     */
    private void aplicarDescuento(Venta venta, Cliente cliente) {
        if (cliente instanceof ClienteVIP clienteVIP) {
            Pago pago = venta.getPago();
            double montoConDescuento = pago.getMonto() * (1 - clienteVIP.getDescuento());
            pago.setMonto(montoConDescuento);
            pagoService.save(pago);
        }
    }
}