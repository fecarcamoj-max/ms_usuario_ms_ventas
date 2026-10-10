package com.desdecero.demodesde0.Ventas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.desdecero.demodesde0.DTO.UsuarioDTO;

@Component 
public class UsuarioClient {
    // Se declara la instancia única y fija
    private final RestClient restClient;

    // Constructor inicializa con los properties de base url del servicio usuario
    public UsuarioClient(@Value("${usuario.service.base-url}") String usuarioServiceBaseUrl){
        this.restClient = RestClient.builder().baseUrl(usuarioServiceBaseUrl).build();
    }

    public UsuarioDTO getUsuario(Integer idUsuario, String jwt){
        
        // Se hace la consulta al MS usuario, <?> es porque existe la posibilidad de que no responda.
        RestClient.RequestHeadersSpec<?> request = restClient.get()
            .uri("api/usuario/usuario/{id}", idUsuario);
        
        if(jwt != null && !jwt.isBlank()){
            request.header(HttpHeaders.AUTHORIZATION, jwt);
        }
        // Se retorna la respuesta del servicio, específicamente el body pero con el formato de DTO
        return request.retrieve().body(UsuarioDTO.class);
    }
}
