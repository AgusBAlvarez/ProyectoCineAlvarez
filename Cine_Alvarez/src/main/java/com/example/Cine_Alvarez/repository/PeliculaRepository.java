package com.example.Cine_Alvarez.repository;

import com.example.Cine_Alvarez.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
}
