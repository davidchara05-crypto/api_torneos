package com.angel.api_torneos.service;

import com.angel.api_torneos.dto.TorneoRequest;
import com.angel.api_torneos.model.Torneo;
import com.angel.api_torneos.repository.TorneoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TorneoService {

    private final TorneoRepository torneoRepository;

    public TorneoService(TorneoRepository torneoRepository) {
        this.torneoRepository = torneoRepository;
    }

    // CREATE
    public Torneo crear(TorneoRequest request) {

        Torneo torneo = new Torneo(
                null,
                request.nombre(),
                request.ciudad(),
                request.categoria(),
                request.numeroEquipos(),
                request.fechaInicio()
        );

        return torneoRepository.save(torneo);
    }

    // READ - Todos
    public List<Torneo> obtenerTodos() {
        return torneoRepository.findAll();
    }

    // READ - Por ID
    public Optional<Torneo> obtenerPorId(Long id) {
        return torneoRepository.findById(id);
    }

    // UPDATE
    public Optional<Torneo> actualizar(
            Long id,
            TorneoRequest request) {

        return torneoRepository.findById(id)
                .map(torneo -> {

                    torneo.setNombre(request.nombre());
                    torneo.setCiudad(request.ciudad());
                    torneo.setCategoria(request.categoria());
                    torneo.setNumeroEquipos(request.numeroEquipos());
                    torneo.setFechaInicio(request.fechaInicio());

                    return torneoRepository.save(torneo);
                });
    }

    // DELETE
    public boolean eliminar(Long id) {

        if (!torneoRepository.existsById(id)) {
            return false;
        }

        torneoRepository.deleteById(id);
        return true;
    }

    // CONSULTA PERSONALIZADA
    public List<Torneo> buscarPorCiudad(String ciudad) {
        return torneoRepository.findByCiudadIgnoreCase(ciudad);
    }
}