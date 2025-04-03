package com.example.pedidosApp.servicios;

import com.example.pedidosApp.modelos.Entrega;
import com.example.pedidosApp.repositorios.IEntrega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaServicio {

    @Autowired
    IEntrega repositorio;
    // Listar los metodos que activaran las consultas en la Base de Datos (BD)

    // Guardar
    public Entrega guardarEntrega(Entrega datosEntrega) throws Exception{
        try{
            // Validar los datos de entrada
            return this.repositorio.save(datosEntrega);

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar todos los registros
    public List<Entrega> buscarEntregas() throws Exception{
        try{

            return this.repositorio.findAll();

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar por ID
    public Entrega buscarEntregaPorId(Integer idEntrega) throws Exception{
        try{

            Optional<Entrega> entregaBuscado=this.repositorio.findById(idEntrega);
            if (entregaBuscado.isPresent()){
                return entregaBuscado.get();
            }else {
                throw new Exception("La entrega consultada no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar por ID
    public Entrega modificarEntrega(Integer id, Entrega datosEntrega) throws Exception{
        try{

            Optional<Entrega> entregaBuscado=this.repositorio.findById(id);
            if (entregaBuscado.isPresent()){
                entregaBuscado.get().setFechaEntrega(datosEntrega.getFechaEntrega());
                entregaBuscado.get().setEstadoEntrega(datosEntrega.getEstadoEntrega());
                return this.repositorio.save(entregaBuscado.get());
            }else{
                throw new Exception("Entrega no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarEntrega(Integer id) throws Exception{
        try{

            Optional<Entrega> entregaBuscado=this.repositorio.findById(id);
            if (entregaBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Entrega no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
