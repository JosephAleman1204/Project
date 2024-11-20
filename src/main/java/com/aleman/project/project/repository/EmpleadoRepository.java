package com.aleman.project.project.repository;

import com.aleman.project.project.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByEmail(String email);
}

