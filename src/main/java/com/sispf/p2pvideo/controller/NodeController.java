/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sispf.p2pvideo.controller;


import com.sispf.p2pvideo.service.NodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import model.Fragment;
import model.Node;

/**
 *
 * @author antoniosalinas
 * Aqui va el rest controller para la interacccion con el sistema, 
 * principalmente el endpoint para solicitar y gestionar nodos/fragmentos
 */
@RestController
@RequestMapping("/api/nodes")
@Tag(name = "Gestión de Nodos", description = "Endpoints para interactuar con los nodos P2P simulados.")
public class NodeController {

    private final NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @GetMapping("/{nodeId}")
    @Operation(summary = "Obtiene los detalles de un nodo por su ID.")
    public ResponseEntity<Node> getNodeDetails(@PathVariable String nodeId) {
        Node node = nodeService.getNodeById(nodeId);
        if (node == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(node);
    }
    
    @PostMapping("/{sourceNodeId}/request/{targetNodeId}/{fragmentId}")
    @Operation(summary = "Simula la solicitud de un fragmento de un nodo a otro.")
    public ResponseEntity<String> requestFragment(
            @PathVariable String sourceNodeId,
            @PathVariable String targetNodeId,
            @PathVariable String fragmentId) {
        
        System.out.println("----------------------------------------");
        System.out.println("Solicitud REST recibida:");
        System.out.println("  - Desde Node " + sourceNodeId);
        System.out.println("  - A Node " + targetNodeId);
        System.out.println("  - Fragmento " + fragmentId);

        
        // El método requestFragment devuelve Optional<Fragment>
        Optional<Fragment> fragmentResult = nodeService.requestFragment(sourceNodeId, targetNodeId, fragmentId);
        
        // Verificamos si el Optional contiene un fragmento
        if (fragmentResult.isPresent()) {
            // Si está presente, obtenemos el objeto Fragment y luego sus datos
            // byte[] fragmentContent = fragmentResult.get().getData(); 
            // Aunque no es necesario usar los datos en la respuesta, puedes acceder a ellos así.
            return ResponseEntity.ok("Transferencia exitosa. Fragmento " + fragmentId + " recibido por " + sourceNodeId);
        } else {
            return ResponseEntity.badRequest().body("Fallo en la transferencia. El nodo destino no tiene el fragmento.");
        }
    }
}