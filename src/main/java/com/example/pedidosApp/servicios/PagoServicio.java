package com.example.pedidosApp.servicios;

import com.example.pedidosApp.modelos.Pago;
import com.example.pedidosApp.repositorios.IPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServicio {

    @Autowired
    IPago repositorio;
    // Listar los metodos que activaran las consultas en la Base de Datos (BD)

    // Guardar
    public Pago guardarPago(Pago datosPago) throws Exception{
        try{
            // Validar los datos de entrada
            return this.repositorio.save(datosPago);

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar todos los registros
    public List<Pago> buscarPagos() throws Exception{
        try{

            return this.repositorio.findAll();

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar por ID
    public Pago buscarPagoPorId(Integer idPago) throws Exception{
        try{

            Optional<Pago> pagoBuscado=this.repositorio.findById(idPago);
            if (pagoBuscado.isPresent()){
                return pagoBuscado.get();
            }else {
                throw new Exception("El pago consultado no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar por ID
    public Pago modificarPago(Integer id, Pago datosPago) throws Exception{
        try{

            Optional<Pago> pagoBuscado=this.repositorio.findById(id);
            if (pagoBuscado.isPresent()){
                pagoBuscado.get().setMetododepago(datosPago.getMetododepago());
                pagoBuscado.get().setEstado(datosPago.getEstado());
                return this.repositorio.save(pagoBuscado.get());
            }else{
                throw new Exception("Pago no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarPago(Integer id) throws Exception{
        try{

            Optional<Pago> pagoBuscado=this.repositorio.findById(id);
            if (pagoBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Pago no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
