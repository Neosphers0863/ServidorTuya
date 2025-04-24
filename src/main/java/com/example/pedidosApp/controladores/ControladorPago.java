package com.example.pedidosApp.controladores;

import com.example.pedidosApp.modelos.Pago;
import com.example.pedidosApp.modelos.Pedido;
import com.example.pedidosApp.servicios.PagoServicio;
import com.example.pedidosApp.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pago")
public class ControladorPago {

    @Autowired
    PagoServicio pagoServicio;

    //Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Pago datosPeticion){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.pagoServicio.guardarPago(datosPeticion));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Buscar Todos
    @GetMapping
    public ResponseEntity<?>buscarTodo(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.pagoServicio.buscarPagos());

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Buscar ID
    @GetMapping("/{id}")
    public ResponseEntity<?>buscarID(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.pagoServicio.buscarPagoPorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Pago datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.pagoServicio.modificarPago(id,datos));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }


    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.pagoServicio.eliminarPago(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
