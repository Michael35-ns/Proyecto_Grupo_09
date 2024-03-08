package com.proyectoHealthyMind.dao;

import com.proyectoHealthyMind.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    
}
