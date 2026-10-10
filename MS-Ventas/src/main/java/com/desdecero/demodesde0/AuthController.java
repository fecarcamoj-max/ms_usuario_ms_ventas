package com.desdecero.demodesde0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desdecero.demodesde0.DTO.AuthRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest json_) {
        // Aquí validarías contra tu base de datos si el usuario existe.
        // Se debe retornar antes si existe o no el usuario.........
        // Como es un ejemplo básico, generamos el token directamente con el nombre enviado:
        return jwtUtil.generateToken(json_.getUsername());
    }
}