package com.example.Cine_Alvarez.repository;

import com.example.Cine_Alvarez.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}