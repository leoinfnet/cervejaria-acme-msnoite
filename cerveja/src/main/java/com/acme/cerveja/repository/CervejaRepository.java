package com.acme.cerveja.repository;

import com.acme.cerveja.model.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CervejaRepository extends JpaRepository<Cerveja, Long> {
}
