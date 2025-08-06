/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sispf.p2pvideo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author antoniosalinas
 * 
 * Aqui se hacen las configuraciones para Swagger
 */

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI p2pVideoApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API de Intercambio P2p de Fragmentos de Video")
                        .description("Sistema distribuido P2P para intercambio de fragmentos de video entre nodos virtuales.")
                        .version("1.0.0"));
    }
}
