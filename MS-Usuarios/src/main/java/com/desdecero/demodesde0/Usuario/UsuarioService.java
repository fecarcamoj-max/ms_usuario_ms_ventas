package com.desdecero.demodesde0.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class UsuarioService { // Lógica del negocio, dominio...

    @Autowired  // Se instancia solo apenas parte corriendo SpringBoot.
    private UsuarioRepository usuarioRepository;

    // Traer a todos los usuarios::::
    public List<Usuario> getUsuarios(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

    // Guardar...
    public Usuario saveUsuario(Usuario us){
        return usuarioRepository.save(us);
    }

    // Traer usuario por ID.
    public Optional<Usuario> getUsuario(Integer id){
        return usuarioRepository.findById(id);
    }

}
