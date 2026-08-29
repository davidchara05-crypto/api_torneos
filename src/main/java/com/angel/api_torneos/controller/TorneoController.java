package com.angel.api_torneos.controller;

import com.angel.api_torneos.dto.TorneoRequest;
import com.angel.api_torneos.model.Torneo;
import com.angel.api_torneos.service.TorneoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/torneos")
public class TorneoController {

    private final TorneoService torneoService;

    public TorneoController(TorneoService torneoService) {
        this.torneoService = torneoService;
    }

    @GetMapping
    public ResponseEntity<List<Torneo>> obtenerTodos() {

        List<Torneo> torneos = torneoService.obtenerTodos();

        return ResponseEntity.ok(torneos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Torneo> obtenerPorId(
            @PathVariable Long id) {

        return torneoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Torneo>> buscarPorCiudad(
            @RequestParam String ciudad) {

        List<Torneo> torneos =
                torneoService.buscarPorCiudad(ciudad);

        return ResponseEntity.ok(torneos);
    }

    @PostMapping
    public ResponseEntity<Torneo> crearTorneo(
            @RequestBody TorneoRequest request) {

        Torneo torneoCreado =
                torneoService.crear(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(torneoCreado);
    }
}