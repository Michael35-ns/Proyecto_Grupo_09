/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoHealthyMind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enfermedad")
public class RechazoController {
    
    @GetMapping("/rechazo")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "/enfermedad/rechazo";
    }
}
