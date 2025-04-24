package com.example.pedidosApp.controladores;

import com.example.pedidosApp.modelos.Pedido;
import com.example.pedidosApp.modelos.Producto;
import com.example.pedidosApp.servicios.PedidoServicio;
import com.example.pedidosApp.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class ControladorPedido {

    @Autowired
    PedidoServicio pedidoServicio;

    //Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Pedido datosPeticion){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.pedidoServicio.guardarPedido(datosPeticion));

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
                    .body(this.pedidoServicio.buscarPedidos());

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
                    .body(this.pedidoServicio.buscarPedidoPorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Pedido datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.pedidoServicio.modificarPedido(id,datos));

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
                    .body(this.pedidoServicio.eliminarPedido(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
