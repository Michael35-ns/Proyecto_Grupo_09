
package com.proyectoHealthyMind.controller;

import com.proyectoHealthyMind.domain.Usuario;
import com.proyectoHealthyMind.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {
        
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/listado")
    public String page(Model model) {
        List<Usuario> lista = usuarioService.getUsuarios(false);
        model.addAttribute("usuarios", lista);
        model.addAttribute("totalUsuarios",lista.size());
        return "/usuario/listado";
    }
    
    @GetMapping("/nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "/usuario/modifica";
    }

//    @Autowired
//    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
//        if (!imagenFile.isEmpty()) {
//            usuarioService.save(usuario);
//            usuario.setRutaImagen(
//                    firebaseStorageService.cargaImagen(
//                            imagenFile, 
//                            "usuario", 
//                            usuario.getIdUsuario()));
//        }
        usuarioService.save(usuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
}
