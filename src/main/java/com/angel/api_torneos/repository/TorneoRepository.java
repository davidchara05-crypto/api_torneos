package com.angel.api_torneos.repository;

import com.angel.api_torneos.model.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TorneoRepository
        extends JpaRepository<Torneo, Long> {

    List<Torneo> findByCiudadIgnoreCase(String ciudad);

}