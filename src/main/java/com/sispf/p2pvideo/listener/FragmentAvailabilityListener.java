/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sispf.p2pvideo.listener;

import com.sispf.p2pvideo.event.FragmentAvailabilityEvent;
import com.sispf.p2pvideo.service.NodeService;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author antoniosalinas
 * Clase que "escuchan" los eventos
 */
@Component
public class FragmentAvailabilityListener {

    private final NodeService nodeService;

    public FragmentAvailabilityListener(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @EventListener
    public void onFragmentAvailabilityEvent(FragmentAvailabilityEvent event) {
        String fragmentId = event.getFragmentId();
        String sourceNodeId = event.getSourceNodeId();

        // Esta es la lógica de cada nodo. Al recibir la notificación,
        // cada nodo podría decidir si le interesa ese fragmento.
        // Aquí simulamos que los nodos 2 y 3 reaccionan a lo que hace el 1.
        
        System.out.println("<- [Pub/Sub] Listener: Evento recibido. Fragmento " + fragmentId + " disponible en " + sourceNodeId);

        
    }
}