/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sispf.p2pvideo.service;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import model.Fragment;
import model.Node;

/**
 *
 * @author antoniosalinas
 * Gestiona la división y distribución de fragmentos
 */

@Service
public class FragmentManagerService {
    
     private final ResourceLoader resourceLoader;
    
    // Mapa para almacenar los fragmentos creados.
    private final Map<String, Fragment> allFragments = new ConcurrentHashMap<>();
    
    // Mapa para saber qué nodos tienen qué fragmentos.
    private final Map<String, List<String>> nodeFragments = new ConcurrentHashMap<>();

    // Nombre del archivo de video en la carpeta de recursos.
    @Value("classpath:video.mp4")
    private Resource videoResource;

    public FragmentManagerService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    
    @PostConstruct
    public void init() throws IOException {
        System.out.println("Iniciando la división del video y la distribución de fragmentos...");
        
        // 1. Dividir el video
        byte[] videoData = videoResource.getContentAsByteArray();
        int fragmentSize = videoData.length / 10;
        
        for (int i = 0; i < 10; i++) {
            int start = i * fragmentSize;
            int end = (i == 9) ? videoData.length : start + fragmentSize;
            byte[] fragmentData = Arrays.copyOfRange(videoData, start, end);
            
            Fragment fragment = new Fragment(fragmentData);
            fragment.setOriginalVideoId("video.mp4");
            allFragments.put(fragment.getId(), fragment);
        }
        
        System.out.println("Video dividido en " + allFragments.size() + " fragmentos.");

        // 2. Distribuir los fragmentos entre 3 nodos simulados
        List<String> fragmentIds = new ArrayList<>(allFragments.keySet());
        Collections.shuffle(fragmentIds); // Mezclamos los fragmentos para una distribución aleatoria
        
        // Creamos 3 nodos simulados
        String nodeId1 = "node-1";
        String nodeId2 = "node-2";
        String nodeId3 = "node-3";

        // Distribuimos los fragmentos entre los nodos. 
        // Cada nodo tendrá una parte del video, pero le faltarán otras.
        nodeFragments.put(nodeId1, new ArrayList<>(fragmentIds.subList(0, 4))); // Fragmentos 0-3
        nodeFragments.put(nodeId2, new ArrayList<>(fragmentIds.subList(4, 7))); // Fragmentos 4-6
        nodeFragments.put(nodeId3, new ArrayList<>(fragmentIds.subList(7, 10))); // Fragmentos 7-9

        System.out.println("Fragmentos distribuidos entre los nodos: " + nodeFragments.keySet());
    }

    /**
     * Retorna la lista de IDs de fragmentos que posee un nodo.
     */
    public List<String> getFragmentsByNode(String nodeId) {
        return nodeFragments.getOrDefault(nodeId, Collections.emptyList());
    }

    /**
     * Retorna el contenido de un fragmento dado su ID.
     */
    public Optional<Fragment> getFragmentById(String fragmentId) {
        return Optional.ofNullable(allFragments.get(fragmentId));
    }
    
    // Método para agregar un fragmento a un nodo (simulando una transferencia P2P)
    public void addFragmentToNode(String nodeId, String fragmentId) {
        nodeFragments.computeIfAbsent(nodeId, k -> new ArrayList<>()).add(fragmentId);
        System.out.println("Fragmento " + fragmentId + " añadido a " + nodeId);
    }
}
