/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sispf.p2pvideo.event;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @author antoniosalinas
 * Clases de eventos para el Pub/Sub interno
 */
public class FragmentAvailabilityEvent extends ApplicationEvent{
    
    private final String fragmentId;
    private final String sourceNodeId;

    public FragmentAvailabilityEvent(Object source, String fragmentId, String sourceNodeId) {
        super(source);
        this.fragmentId = fragmentId;
        this.sourceNodeId = sourceNodeId;
    }

    public String getFragmentId() {
        return fragmentId;
    }

    public String getSourceNodeId() {
        return sourceNodeId;
    }
}
