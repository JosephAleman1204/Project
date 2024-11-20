package com.aleman.project.project.service;

import com.aleman.project.project.entity.Dispositivo;
import com.aleman.project.project.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DispositivoService {
    @Autowired
    private DispositivoRepository dispositivoRepository;

    public List<Dispositivo> validarDispositivos(List<Dispositivo> dispositivos) {
        return dispositivos.stream()
                .filter(this::esDispositivoValido)
                .collect(Collectors.toList());
    }

    private boolean esDispositivoValido(Dispositivo dispositivo) {
        return dispositivo.getEstado().equals("LISTO_PARA_USAR") &&
                dispositivo.getPuntaje() > 60 &&
                !esPalindromo(dispositivo.getImei());
    }

    private boolean esPalindromo(String imei) {
        return new StringBuilder(imei).reverse().toString().equals(imei);
    }
}

