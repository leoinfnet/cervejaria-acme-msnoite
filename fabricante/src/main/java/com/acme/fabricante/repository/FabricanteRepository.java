package com.acme.fabricante.repository;

import com.acme.fabricante.model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}
