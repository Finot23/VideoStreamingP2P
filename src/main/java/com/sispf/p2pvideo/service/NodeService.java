/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sispf.p2pvideo.service;

import java.util.Collections;
import java.util.HashSet;
import model.Fragment;
import model.Node;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author antoniosalinas
 * La lógica interna de cada nodo
 */

@Service
public class NodeService {
    private final FragmentManagerService fragmentManagerService;
    private final EventPublisherService eventPublisherService;
    
    // Almacenamos los nodos simulados en memoria.
    private final Node node1 = new Node();
    private final Node node2 = new Node();
    private final Node node3 = new Node();

    public NodeService(FragmentManagerService fragmentManagerService, EventPublisherService eventPublisherService) {
        this.fragmentManagerService = fragmentManagerService;
        this.eventPublisherService = eventPublisherService;
        
        // Asignamos los fragmentos iniciales a cada nodo.
       
        this.node1.getFragmentIds().addAll(fragmentManagerService.getFragmentsByNode("node-1"));
        this.node2.getFragmentIds().addAll(fragmentManagerService.getFragmentsByNode("node-2"));
        this.node3.getFragmentIds().addAll(fragmentManagerService.getFragmentsByNode("node-3"));

        System.out.println("Nodos inicializados:");
        System.out.println("Node 1 (" + node1.getId() + ") tiene " + node1.getFragmentIds().size() + " fragmentos.");
        System.out.println("Node 2 (" + node2.getId() + ") tiene " + node2.getFragmentIds().size() + " fragmentos.");
        System.out.println("Node 3 (" + node3.getId() + ") tiene " + node3.getFragmentIds().size() + " fragmentos.");
    }
    
    public Node getNodeById(String nodeId) {
        
        if (node1.getId().equals(nodeId)) {
            return node1;
        }
        if (node2.getId().equals(nodeId)) {
            return node2;
        }
        if (node3.getId().equals(nodeId)) {
            return node3;
        }
        return null;
    }

    /**
     * Simula la solicitud de un fragmento a otro nodo.
     */
     public Optional<Fragment> requestFragment(String sourceNodeId, String targetNodeId, String fragmentId) {
        Node targetNode = getNodeById(targetNodeId);
        if (targetNode != null && targetNode.hasFragment(fragmentId)) {
            System.out.println("Node " + sourceNodeId + " solicitando fragmento " + fragmentId + " a " + targetNodeId);
            
            Optional<Fragment> fragment = fragmentManagerService.getFragmentById(fragmentId);
            if (fragment.isPresent()) {
                Node sourceNode = getNodeById(sourceNodeId);
                if (sourceNode != null) {
                    sourceNode.addFragment(fragmentId);
                    System.out.println("Node " + sourceNodeId + " ha recibido el fragmento " + fragmentId);
                    
                    // Publicamos el evento de disponibilidad.
                    eventPublisherService.publishFragmentAvailabilityEvent(fragmentId, sourceNodeId);
                }
                return fragment;
            }
        }
        System.out.println("Node " + targetNodeId + " no tiene el fragmento " + fragmentId + " o no existe.");
        return Optional.empty();
    }

    /**
     * Devuelve el conjunto de IDs de fragmentos que le faltan a un nodo.
     */
    public Set<String> getMissingFragments(String nodeId) {
        // En un sistema real, un nodo podría no saber cuántos fragmentos hay en total.
        // Aquí lo sabemos porque los gestionamos centralmente.
        Set<String> allFragmentIds = fragmentManagerService.getAllFragmentIds();
        Node node = getNodeById(nodeId);
        if (node == null) {
            return Collections.emptySet();
        }
        
        Set<String> missingFragments = new HashSet<>(allFragmentIds);
        missingFragments.removeAll(node.getFragmentIds());
        return missingFragments;
    }
}
