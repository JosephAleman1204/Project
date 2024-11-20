package com.aleman.project.project.repository;

import com.aleman.project.project.entity.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    List<Dispositivo> findByProveedor(String proveedor);
    Optional<Dispositivo> findByImei(String imei);
}

