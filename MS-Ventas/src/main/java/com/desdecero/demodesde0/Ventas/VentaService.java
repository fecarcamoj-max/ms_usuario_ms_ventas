package com.desdecero.demodesde0.Ventas;

import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class VentaService {

    private final VentaRepository ventaRepository;

    // Constructor...
    public VentaService(VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
    }

    // SERVICIOS ... LISTAR TODAS LAS VENTAS.... MS USUARIO...

    public List<Venta> getVentas(){
        return (List<Venta>) ventaRepository.findAll();     
    }

    
}
