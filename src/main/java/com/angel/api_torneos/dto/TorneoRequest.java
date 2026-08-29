package com.angel.api_torneos.dto;

import java.time.LocalDate;

public record TorneoRequest(
        String nombre,
        String ciudad,
        String categoria,
        int numeroEquipos,
        LocalDate fechaInicio
) {
}