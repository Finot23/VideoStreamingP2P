/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproyect.nodo1.services;

import com.finalproyect.nodo2.services.Nodo2Service;
import com.finalproyect.shared.models.Fragmento;
import com.finalproyect.shared.models.Solicitud;

/**
 *
 * @author antoniosalinas
 */
public class Nodo1Service {
    
    // Se crea el objeto nodo 2 de la Clase Nodo2Service
  private Nodo2Service nodo2;
    
  //Se genera el constructor de nodo2
    public Nodo1Service(Nodo2Service nodo2) {
        this.nodo2 = nodo2;
    }
  
    /*Se crea el metodo solicitarFragmento pasando la clase Fragmento y 
    su atributo idFragmento donde se va a crear un objeto de la clase Solicitud
   
   public Fragmento solicitarFragmento(String idFragmento) {
        Solicitud solicitud = new Solicitud("S001", "Nodo1", "Nodo2", idFragmento);
        return nodo2.procesarSolicitud(solicitud);
    }
   */
}
