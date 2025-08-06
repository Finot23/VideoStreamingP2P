/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author antoniosalinas
 * Representación de un nodo P2P
 */
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Node {

    private final String id;
    private final Set<String> fragmentIds; // Guardaremos los IDs de los fragmentos que tiene el nodo

    public Node() {
        this.id = UUID.randomUUID().toString(); // ID único para cada nodo simulado
        this.fragmentIds = new HashSet<>();
    }

    // Métodos para gestionar los fragmentos
    public void addFragment(String fragmentId) {
        this.fragmentIds.add(fragmentId);
    }

    public void removeFragment(String fragmentId) {
        this.fragmentIds.remove(fragmentId);
    }

    public boolean hasFragment(String fragmentId) {
        return this.fragmentIds.contains(fragmentId);
    }

    // Getters
    public String getId() {
        return id;
    }

    public Set<String> getFragmentIds() {
        return fragmentIds;
    }
}
