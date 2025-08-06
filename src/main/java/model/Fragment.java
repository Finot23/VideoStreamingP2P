/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;

/**
 *
 * @author antoniosalinas
 * Representación de un fragmento de video
 */
public class Fragment {
    private final String id;
    private final byte[] data; // Usamos un array de bytes para simular el contenido del video
    private String originalVideoId;

    public Fragment(byte[] data) {
        this.id = UUID.randomUUID().toString(); // Generamos un ID único para cada fragmento
        this.data = data;
    }

    // Getters
    public String getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }

    public String getOriginalVideoId() {
        return originalVideoId;
    }

    public void setOriginalVideoId(String originalVideoId) {
        this.originalVideoId = originalVideoId;
    }
}
