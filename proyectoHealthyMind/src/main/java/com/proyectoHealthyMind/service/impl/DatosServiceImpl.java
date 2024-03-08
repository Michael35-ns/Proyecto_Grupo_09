package com.proyectoHealthyMind.service.impl;

import com.proyectoHealthyMind.dao.DatosDao;
import com.proyectoHealthyMind.domain.Datos;
import com.proyectoHealthyMind.service.DatosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatosServiceImpl implements DatosService {

    @Autowired
    private DatosDao datosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Datos> getDatos(boolean activos) {
        var lista = datosDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Datos getDatos(Datos usuario) {
        return datosDao.findById(usuario.getIdDatos()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Datos usuario) {
        datosDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Datos usuario) {
        datosDao.delete(usuario);
    }
}
