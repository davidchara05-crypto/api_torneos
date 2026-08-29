package com.angel.api_torneos.service;

import com.angel.api_torneos.dto.TorneoRequest;
import com.angel.api_torneos.model.Torneo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TorneoService {

    private final List<Torneo> torneos = new ArrayList<>();

    private Long siguienteId = 1L;

    public TorneoService() {

        torneos.add(new Torneo(
                siguienteId++,
                "Copa Meta 2026",
                "Villavicencio",
                "Sub-15",
                12,
                LocalDate.of(2026, 9, 10)
        ));

        torneos.add(new Torneo(
                siguienteId++,
                "Liga Regional",
                "Acacias",
                "Sub-17",
                10,
                LocalDate.of(2026, 10, 5)
        ));
    }

    public List<Torneo> obtenerTodos() {
        return torneos;
    }

    public Optional<Torneo> obtenerPorId(Long id) {

        return torneos.stream()
                .filter(torneo -> torneo.getId().equals(id))
                .findFirst();
    }

    public List<Torneo> buscarPorCiudad(String ciudad) {

        return torneos.stream()
                .filter(torneo ->
                        torneo.getCiudad()
                                .equalsIgnoreCase(ciudad)
                )
                .toList();
    }

    public Torneo crear(TorneoRequest request) {

        Torneo torneo = new Torneo(
                siguienteId++,
                request.nombre(),
                request.ciudad(),
                request.categoria(),
                request.numeroEquipos(),
                request.fechaInicio()
        );

        torneos.add(torneo);

        return torneo;
    }
}