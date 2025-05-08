package com.pds.taller.Barberia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pds.taller.Barberia.model.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByFecha(String fecha);
}
