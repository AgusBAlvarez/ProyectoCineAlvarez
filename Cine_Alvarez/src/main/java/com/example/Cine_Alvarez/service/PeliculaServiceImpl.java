package com.example.Cine_Alvarez.service;

import com.example.Cine_Alvarez.entity.Pelicula;
import com.example.Cine_Alvarez.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula findById(int id) {
        return peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelicula no encontrada: " + id));
    }

    @Override
    public Pelicula save(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public void deleteById(int id) {
        peliculaRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pelicula update(int id, Pelicula pelicula) {
        Pelicula existente = peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelicula no encontrada: " + id));
        existente.setTitulo(pelicula.getTitulo());
        existente.setGenero(pelicula.getGenero());
        return peliculaRepository.save(existente);
    }
}