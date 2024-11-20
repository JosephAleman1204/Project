package com.aleman.project.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contraseña;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    private LocalDate fechaContratacion;
    private LocalDateTime ultimoAcceso;
    private String estado;
}

