package com.aleman.project.project.jwt;

import com.aleman.project.project.entity.Empleado;
import com.aleman.project.project.entity.Rol;
import com.aleman.project.project.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmpleadoRepository empleadoRepository; // Asegúrate de tener este repositorio

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Buscar usuario en la base de datos
        Empleado empleado = empleadoRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el email: " + email));

        // Convertir el usuario en UserDetails
        return new User(empleado.getEmail(), empleado.getContraseña(),
                empleado.getRol().equals(Rol.COORDINADOR)
                        ? List.of(new SimpleGrantedAuthority("ROLE_COORDINADOR"))
                        : List.of(new SimpleGrantedAuthority("ROLE_VALIDADOR")));
    }
}
