/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproyect.shared.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antoniosalinas
 * Clase que representa a un nodo virtual. 
 * Podría tener un id, el nombre del nodo, y una lista de los 
 * fragmentos que posee.
 */
public class Nodo {
    private List<Fragmento> fragmentos;
    
    public Nodo(){
        this.fragmentos = new ArrayList<>();
    }
    
    int idNodo;
    String nombreNodo;
   
     public void agregarFragmento(Fragmento fragmento) {
        fragmentos.add(fragmento);
    }

    public List<Fragmento> getFragmentos() {
        return fragmentos;
    }

    public Nodo(List<Fragmento> fragmentos, int idNodo, String nombreNodo) {
        this.fragmentos = fragmentos;
        this.idNodo = idNodo;
        this.nombreNodo = nombreNodo;
    }

    public int getIdNodo() {
        return idNodo;
    }

    public String getNombreNodo() {
        return nombreNodo;
    }

    public void setFragmentos(List<Fragmento> fragmentos) {
        this.fragmentos = fragmentos;
    }

    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }

    public void setNombreNodo(String nombreNodo) {
        this.nombreNodo = nombreNodo;
    }
    
    
    
}
