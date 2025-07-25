/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproyect.shared.models;

/**
 *
 * @author antoniosalinas
 * Esta clase representa un fragmento del video. Debería contener atributos 
 * como el id del fragmento, el nombre del archivo, y el contenido.
 */
public class Fragmento {
     int idFragmento;
     String nombreArchivo;
     private String contenido;

    public Fragmento(int idFragmento, String nombreArchivo, String contenido) {
        this.idFragmento = idFragmento;
        this.nombreArchivo = nombreArchivo;
        this.contenido = contenido;
    }

    public int getIdFragmento() {
        return idFragmento;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setIdFragmento(int idFragmento) {
        this.idFragmento = idFragmento;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    
     

    
}
