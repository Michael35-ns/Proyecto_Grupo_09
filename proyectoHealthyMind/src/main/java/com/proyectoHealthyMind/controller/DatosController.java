
package com.proyectoHealthyMind.controller;

import com.proyectoHealthyMind.domain.Datos;
import com.proyectoHealthyMind.service.DatosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/datos")
public class DatosController {
        
    @Autowired
    DatosService datosService;
    
    @GetMapping("/listado")
    public String page(Model model) {
        List<Datos> lista = datosService.getDatos(false);
        model.addAttribute("datos", lista);
        model.addAttribute("totalDatos",lista.size());
        return "/datos/listado";
    }
    
    @GetMapping("/nuevo")
    public String datosNuevo(Datos datos) {
        return "/datos/modifica";
    }

//    @Autowired
//    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String datosGuardar(Datos datos,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
//        if (!imagenFile.isEmpty()) {
//            datosService.save(datos);
//            datos.setRutaImagen(
//                    firebaseStorageService.cargaImagen(
//                            imagenFile, 
//                            "datos", 
//                            datos.getIdDatos()));
//        }
        datosService.save(datos);
        return "redirect:/datos/listado";
    }

    @GetMapping("/eliminar/{idDatos}")
    public String datosEliminar(Datos datos) {
        datosService.delete(datos);
        return "redirect:/datos/listado";
    }

    @GetMapping("/modificar/{idDatos}")
    public String datosModificar(Datos datos, Model model) {
        datos = datosService.getDatos(datos);
        model.addAttribute("datos", datos);
        return "/datos/modifica";
    }
}
