package com.example.pedidosApp.servicios;

import com.example.pedidosApp.modelos.Direccion;
import com.example.pedidosApp.repositorios.IDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServicio {

    @Autowired
    IDireccion repositorio;
    // Listar los metodos que activaran las consultas en la Base de Datos (BD)

    // Guardar
    public Direccion guardarDireccion(Direccion datosDireccion) throws Exception{
        try{
            // Validar los datos de entrada
            return this.repositorio.save(datosDireccion);

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar todos los registros
    public List<Direccion> buscarDirecciones() throws Exception{
        try{

            return this.repositorio.findAll();

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar por ID
    public Direccion buscarDireccionPorId(Integer idDireccion) throws Exception{
        try{

            Optional<Direccion> direccionBuscado=this.repositorio.findById(idDireccion);
            if (direccionBuscado.isPresent()){
                return direccionBuscado.get();
            }else {
                throw new Exception("La direccion consultada no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar por ID
    public Direccion modificarDireccion(Integer id, Direccion datosDireccion) throws Exception{
        try{

            Optional<Direccion> direccionBuscado=this.repositorio.findById(id);
            if (direccionBuscado.isPresent()){
                direccionBuscado.get().setCalle(datosDireccion.getCalle());
                direccionBuscado.get().setCiudad(datosDireccion.getCiudad());
                return this.repositorio.save(direccionBuscado.get());
            }else{
                throw new Exception("Direccion no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarDireccion(Integer id) throws Exception{
        try{

            Optional<Direccion> direccionBuscado=this.repositorio.findById(id);
            if (direccionBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Direccion no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
