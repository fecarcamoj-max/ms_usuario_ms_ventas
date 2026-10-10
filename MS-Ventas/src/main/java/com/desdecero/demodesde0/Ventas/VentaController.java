package com.desdecero.demodesde0.Ventas;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.desdecero.demodesde0.DTO.UsuarioDTO;
import com.desdecero.demodesde0.DTO.VentaConUsuarioDTO;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;



@RestController 
@RequestMapping("api/ventas")

public class VentaController {

    private final VentaService ventaService;
    private final UsuarioClient usuarioClient;

    public VentaController(VentaService ventaService, UsuarioClient usuarioClient){
        this.ventaService = ventaService;
        this.usuarioClient = usuarioClient;
    }

    @GetMapping("/getVentas")
    public List<Venta> getVentas() {
        return ventaService.getVentas();
    }

    private VentaConUsuarioDTO toVentaConUsuarioDTO(Venta venta, String jwt_del_request){
        try{
            UsuarioDTO usuarioDTO = usuarioClient.getUsuario(venta.getIdUsuario(), jwt_del_request);
            VentaConUsuarioDTO vcu = new VentaConUsuarioDTO();
            vcu.setIdUsuario(venta.getIdUsuario());
            vcu.setCantidad(venta.getCantidad());
            vcu.setIdVenta(venta.getIdVenta());
            vcu.setPrecio(venta.getPrecio());
            vcu.setProducto(venta.getProducto());
            vcu.setFecha(venta.getFecha());

            // Set Usuario recibido del microservicio
            vcu.setUsuario(usuarioDTO);
            // Se retorna el JSON armado.
            return vcu;
        }catch(Exception exception){
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,
                "NO FUE POSIBLE ENCONTRAR AL USUARIO EN EL MS USUARIO DE ID:"+venta.getIdUsuario()
            );
        }
    }

    @GetMapping("/ventas_con_usuario")
    public List<VentaConUsuarioDTO> getVentasConUsuario(HttpServletRequest request) {
        String jwt_del_request = request.getHeader("Authorization");
        return ventaService.getVentas().stream()
            .map(venta -> toVentaConUsuarioDTO(venta, jwt_del_request))
            .toList();
    }
    

    
}
