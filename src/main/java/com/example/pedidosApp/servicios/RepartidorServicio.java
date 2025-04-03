package com.example.pedidosApp.servicios;

import com.example.pedidosApp.modelos.Repartidor;
import com.example.pedidosApp.repositorios.IRepartidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepartidorServicio {

    @Autowired
    IRepartidor repositorio;
    // Listar los metodos que activaran las consultas en la Base de Datos (BD)

    // Guardar
    public Repartidor guardarRepartidor(Repartidor datosRepartidor) throws Exception{
        try{
            // Validar los datos de entrada
            return this.repositorio.save(datosRepartidor);

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar todos los registros
    public List<Repartidor> buscarRepartidores() throws Exception{
        try{

            return this.repositorio.findAll();

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar por ID
    public Repartidor buscarRepartidorPorId(Integer idRepartidor) throws Exception{
        try{

            Optional<Repartidor> repartidorBuscado=this.repositorio.findById(idRepartidor);
            if (repartidorBuscado.isPresent()){
                return repartidorBuscado.get();
            }else {
                throw new Exception("El repartidor consultado no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar por ID
    public Repartidor modificarRepartidor(Integer id, Repartidor datosRepartidor) throws Exception{
        try{

            Optional<Repartidor> repartidorBuscado=this.repositorio.findById(id);
            if (repartidorBuscado.isPresent()){
                repartidorBuscado.get().setTelefono(datosRepartidor.getTelefono());
                repartidorBuscado.get().setCorreoEletronico(datosRepartidor.getCorreoEletronico());
                return this.repositorio.save(repartidorBuscado.get());
            }else{
                throw new Exception("Repartidor no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarRepartidor(Integer id) throws Exception{
        try{

            Optional<Repartidor> repartidorBuscado=this.repositorio.findById(id);
            if (repartidorBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Repartidor no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
