package com.aleman.project.project.service;

import com.aleman.project.project.entity.Proveedor;
import com.aleman.project.project.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Optional<Proveedor> buscarPorNombre(String nombre) {
        return proveedorRepository.findByNombre(nombre);
    }
}

