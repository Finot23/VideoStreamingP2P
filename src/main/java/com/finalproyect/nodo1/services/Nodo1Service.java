/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproyect.nodo1.services;


import com.finalproyect.shared.models.Fragmento;
import com.finalproyect.shared.models.Nodo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antoniosalinas
 */

@Service
public class Nodo1Service {

    // Simulación de los datos del Nodo 1 en memoria
    private final Nodo nodo1 = new Nodo(1, "Nodo1", new ArrayList<>());

    public List<Fragmento> getFragmentos() {
        return nodo1.getFragmentos();
    }

    public void addFragmento(Fragmento fragmento) {
        nodo1.getFragmentos().add(fragmento);
    }

    // Método para simular la solicitud de un fragmento a otro nodo (ej. Nodo 2)
    public Fragmento solicitarFragmentoANodo2(int fragmentoId) {
        System.out.println("Nodo1 solicita el fragmento " + fragmentoId + " al Nodo2.");
        // Aquí iría la lógica para llamar al servicio del Nodo2.
        // Dado que es una aplicación monolítica, no necesitas una llamada HTTP.
        // Podrías inyectar el servicio del Nodo2 y llamarlo directamente.
        // Ejemplo:
        // @Autowired
        // private Nodo2Service nodo2Service;
        // return nodo2Service.entregarFragmento(fragmentoId);
        return null; // Por ahora, devolvemos null
    }
}