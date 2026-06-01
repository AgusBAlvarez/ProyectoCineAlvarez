package com.example.Cine_Alvarez.mapper;

import com.example.Cine_Alvarez.dto.FuncionDTO;
import com.example.Cine_Alvarez.entity.Funcion;
import org.springframework.stereotype.Component;

@Component
public class FuncionMapper {
    public FuncionDTO toDTO(Funcion f) {
        String titulo = "-";
        String genero = "-";
        if (f.getPeliculas() != null) {
            titulo = f.getPeliculas().getTitulo() != null ? f.getPeliculas().getTitulo() : "-";
            genero = f.getPeliculas().getGenero() != null ? f.getPeliculas().getGenero().toString() : "-";
        }
        String horario = f.getHorario() != null ? f.getHorario().toString() : "-";
        return new FuncionDTO(f.getId(), horario, titulo, genero);
    }
}