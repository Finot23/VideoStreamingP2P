/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproyect.nodo1.controllers;

import com.finalproyect.nodo1.services.Nodo1Service;
import com.finalproyect.shared.models.Fragmento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author antoniosalinas
 */

@RestController
@RequestMapping("/api/nodo1")

public class Nodo1Controller {

    private final Nodo1Service nodo1Service;

    @Autowired
    public Nodo1Controller(Nodo1Service nodo1Service) {
        this.nodo1Service = nodo1Service;
    }

    @GetMapping("/fragmentos")
    public List<Fragmento> obtenerFragmentos() {
        return nodo1Service.getFragmentos();
    }

    // Endpoint para simular que el Nodo1 recibe un fragmento de otro nodo
    @PostMapping("/recibir-fragmento")
    public String recibirFragmento(@RequestBody Fragmento fragmento) {
        nodo1Service.addFragmento(fragmento);
        return "Fragmento " + fragmento.getId() + " recibido por Nodo1.";
    }

    // Endpoint para que el Nodo1 solicite un fragmento a otro nodo
    @GetMapping("/solicitar-fragmento/{id}")
    public String solicitarFragmento(@PathVariable int id) {
        Fragmento fragmentoSolicitado = nodo1Service.solicitarFragmentoANodo2(id);
        if (fragmentoSolicitado != null) {
            return "Solicitud del fragmento " + id + " enviada. Fragmento recibido.";
        }
        return "Solicitud del fragmento " + id + " enviada. Fragmento no recibido.";
    }
}