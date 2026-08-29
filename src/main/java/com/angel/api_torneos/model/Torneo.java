package com.angel.api_torneos.model;

import java.time.LocalDate;

public class Torneo {

    private Long id;
    private String nombre;
    private String ciudad;
    private String categoria;
    private int numeroEquipos;
    private LocalDate fechaInicio;

    public Torneo() {
    }

    public Torneo(Long id, String nombre, String ciudad,
                  String categoria, int numeroEquipos,
                  LocalDate fechaInicio) {

        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.numeroEquipos = numeroEquipos;
        this.fechaInicio = fechaInicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumeroEquipos() {
        return numeroEquipos;
    }

    public void setNumeroEquipos(int numeroEquipos) {
        this.numeroEquipos = numeroEquipos;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}