package com.example.pedidosApp.controladores;

import com.example.pedidosApp.modelos.Entrega;
import com.example.pedidosApp.modelos.Pago;
import com.example.pedidosApp.servicios.EntregaServicio;
import com.example.pedidosApp.servicios.PagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrega")
public class ControladorEntrega {

    @Autowired
    EntregaServicio entregaServicio;

    //Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Entrega datosPeticion){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.entregaServicio.guardarEntrega(datosPeticion));

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
                    .body(this.entregaServicio.buscarEntregas());

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
                    .body(this.entregaServicio.buscarEntregaPorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Entrega datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.entregaServicio.modificarEntrega(id,datos));

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
                    .body(this.entregaServicio.eliminarEntrega(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
