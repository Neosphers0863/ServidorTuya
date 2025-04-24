package com.example.pedidosApp.controladores;

import com.example.pedidosApp.modelos.Detalle;
import com.example.pedidosApp.modelos.Direccion;
import com.example.pedidosApp.servicios.DetalleServicio;
import com.example.pedidosApp.servicios.DireccionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalle")
public class ControladorDetalle {

    @Autowired
    DetalleServicio detalleServicio;

    //Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Detalle datosPeticion){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.detalleServicio.guardarDetalle(datosPeticion));

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
                    .body(this.detalleServicio.buscarDetalles());

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
                    .body(this.detalleServicio.buscarDetallePorId(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Detalle datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.detalleServicio.modificarDetalle(id,datos));

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
                    .body(this.detalleServicio.eliminarDetalle(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
