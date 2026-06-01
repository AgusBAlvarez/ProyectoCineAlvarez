package com.example.Cine_Alvarez.controller;

import com.example.Cine_Alvarez.entity.Proveedor;
import com.example.Cine_Alvarez.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> findAll(){
        return proveedorService.findAll();
    }

    @GetMapping("/{id}")
    public Proveedor findById(@PathVariable Integer id){
        return proveedorService.findById(id);
    }

    @PostMapping
    public Proveedor save(@RequestBody Proveedor proveedor){
        return proveedorService.save(proveedor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        proveedorService.deleteById(id);
    }
}