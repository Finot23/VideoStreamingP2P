/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalproyect.shared.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

/**
 *
 * @author antoniosalinas
 * Clase que representa a un nodo virtual. 
 * Podría tener un id, el nombre del nodo, y una lista de los 
 * fragmentos que posee.
 */


@Data
@AllArgsConstructor
public class Nodo {
    private int id;
    private String nombre;
    private List<Fragmento> fragmentos;
}