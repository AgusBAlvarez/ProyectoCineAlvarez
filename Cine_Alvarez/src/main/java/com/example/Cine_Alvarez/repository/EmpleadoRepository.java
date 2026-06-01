package com.example.Cine_Alvarez.repository;

import com.example.Cine_Alvarez.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
