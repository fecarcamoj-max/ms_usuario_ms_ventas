package com.desdecero.demodesde0.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController  
@RequestMapping ("/api/usuario")
public class UsuarioController {

    @Autowired 
    private UsuarioService usuarioService;


    @GetMapping("getAll")
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PostMapping("save")
    public Usuario addUsuario(@RequestBody Usuario entity) {
        //TODO: process POST request
        
        return usuarioService.saveUsuario(entity);
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> getUsuario(@PathVariable Integer id){
        return usuarioService.getUsuario(id);
    }
    

}
