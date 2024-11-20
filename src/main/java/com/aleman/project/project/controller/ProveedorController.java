package com.aleman.project.project.controller;

import com.aleman.project.project.entity.Proveedor;
import com.aleman.project.project.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<Proveedor> crear(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorService.crearProveedor(proveedor));
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Proveedor> buscar(@PathVariable String nombre) {
        return proveedorService.buscarPorNombre(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
