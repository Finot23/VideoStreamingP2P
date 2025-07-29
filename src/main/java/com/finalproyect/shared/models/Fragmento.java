/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproyect.shared.models;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 *
 * @author antoniosalinas
 * Esta clase representa un fragmento del video. Debería contener atributos 
 * como el id del fragmento, el nombre del archivo, y el contenido.
 */
    
    @Data
    @AllArgsConstructor
public class Fragmento {
     
    private int id;
    private String nombre;
    private String contenido;
    
}
