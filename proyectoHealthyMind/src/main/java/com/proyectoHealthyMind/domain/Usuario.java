package com.proyectoHealthyMind.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long idUsuario;
    private String correo;
    private String passwords;
    private boolean activo;

    public Usuario(String correo, String passwords, boolean activo) {
        this.correo = correo;
        this.passwords = passwords;
        this.activo = activo;
    }

    public Usuario() {
    }

}
