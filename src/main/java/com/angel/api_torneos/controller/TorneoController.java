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

    // CREATE
    @PostMapping
    public ResponseEntity<Torneo> crearTorneo(
            @RequestBody TorneoRequest request) {

        Torneo torneoCreado = torneoService.crear(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(torneoCreado);
    }

    // READ - Todos
    @GetMapping
    public ResponseEntity<List<Torneo>> obtenerTodos() {

        return ResponseEntity.ok(
                torneoService.obtenerTodos()
        );
    }

    // READ - Por ID
    @GetMapping("/{id}")
    public ResponseEntity<Torneo> obtenerPorId(
            @PathVariable Long id) {

        return torneoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }

    // CONSULTA PERSONALIZADA
    @GetMapping("/buscar")
    public ResponseEntity<List<Torneo>> buscarPorCiudad(
            @RequestParam String ciudad) {

        return ResponseEntity.ok(
                torneoService.buscarPorCiudad(ciudad)
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Torneo> actualizarTorneo(
            @PathVariable Long id,
            @RequestBody TorneoRequest request) {

        return torneoService.actualizar(id, request)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.notFound().build()
                );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTorneo(
            @PathVariable Long id) {

        boolean eliminado = torneoService.eliminar(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}