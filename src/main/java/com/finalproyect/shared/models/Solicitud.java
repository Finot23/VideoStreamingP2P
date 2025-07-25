/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproyect.shared.models;

/**
 *
 * @author antoniosalinas
 * Esta clase maneja las solicitudes de intercambio de fragmentos entre nodos.
 */
public class Solicitud {
    int idSolicitud;
    String nodoOrigen;
    String nodoDestino;
    String idFragmento;
    String estado;

    public Solicitud(int idSolicitud, String nodoOrigen, String nodoDestino, String idFragmento, String estado) {
        this.idSolicitud = idSolicitud;
        this.nodoOrigen = nodoOrigen;
        this.nodoDestino = nodoDestino;
        this.idFragmento = idFragmento;
        this.estado = "pendiente";

    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public String getNodoOrigen() {
        return nodoOrigen;
    }

    public String getNodoDestino() {
        return nodoDestino;
    }

    public String getIdFragmento() {
        return idFragmento;
    }

    public String getEstado() { 
        return estado; }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public void setNodoOrigen(String nodoOrigen) {
        this.nodoOrigen = nodoOrigen;
    }

    public void setNodoDestino(String nodoDestino) {
        this.nodoDestino = nodoDestino;
    }

    public void setIdFragmento(String idFragmento) {
        this.idFragmento = idFragmento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void aceptar(){
        estado = "aceptada";
    }
    
    public void rechazar(){
        estado = "rechazada";
    }
}
