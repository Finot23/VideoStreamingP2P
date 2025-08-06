/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sispf.p2pvideo.service;


import com.sispf.p2pvideo.event.FragmentAvailabilityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 *
 * @author antoniosalinas
 * Publica los eventos internos
 */

@Service
public class EventPublisherService {

    private final ApplicationEventPublisher eventPublisher;

    public EventPublisherService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishFragmentAvailabilityEvent(String fragmentId, String sourceNodeId) {
        System.out.println("-> [Pub/Sub] Publicando evento: Fragmento " + fragmentId + " disponible desde " + sourceNodeId);
        // El 'this' se usa como la fuente del evento.
        FragmentAvailabilityEvent customEvent = new FragmentAvailabilityEvent(this, fragmentId, sourceNodeId);
        eventPublisher.publishEvent(customEvent);
    }
}

