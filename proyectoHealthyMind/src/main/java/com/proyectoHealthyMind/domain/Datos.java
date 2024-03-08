package com.proyectoHealthyMind.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "datos")
public class Datos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_datos")
    private long idDatos;
    private String nombreLibro;
    private String rutaImagen;
    private String rutaLink;
    private boolean activo;

    public Datos(String nombreLibro, String rutaImagen, String rutaLink, boolean activo) {
        this.nombreLibro = nombreLibro;
        this.rutaImagen = rutaImagen;
        this.rutaLink = rutaLink;
        this.activo = activo;
    }

    public Datos() {
    }
}
