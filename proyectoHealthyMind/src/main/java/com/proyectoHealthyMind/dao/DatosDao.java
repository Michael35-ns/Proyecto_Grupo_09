/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectoHealthyMind.dao;

import com.proyectoHealthyMind.domain.Datos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author crisn
 */
public interface DatosDao extends JpaRepository<Datos, Long> {
    
}
