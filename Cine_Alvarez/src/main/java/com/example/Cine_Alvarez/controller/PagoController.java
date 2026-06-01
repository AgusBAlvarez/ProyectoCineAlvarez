package com.example.Cine_Alvarez.controller;

import com.example.Cine_Alvarez.entity.Pago;
import com.example.Cine_Alvarez.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> findAll(){
        return pagoService.findAll();
    }

    @GetMapping("/{id}")
    public Pago findById(@PathVariable Integer id){
        return pagoService.findById(id);
    }

    @PostMapping
    public Pago save(@RequestBody Pago pago){
        return pagoService.save(pago);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        pagoService.deleteById(id);
    }
}