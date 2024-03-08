package com.proyectoHealthyMind.service;

import com.proyectoHealthyMind.domain.Datos;
import java.util.List;

public interface DatosService {
    public List<Datos> getDatos(boolean activos);

    public Datos getDatos(Datos datos);

    public void save(Datos datos);

    public void delete(Datos datos);
}
