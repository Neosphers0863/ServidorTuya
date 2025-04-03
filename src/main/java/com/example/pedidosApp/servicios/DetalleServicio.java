package com.example.pedidosApp.servicios;

import com.example.pedidosApp.modelos.Detalle;
import com.example.pedidosApp.repositorios.IDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleServicio {

    @Autowired
    IDetalle repositorio;
    // Listar los metodos que activaran las consultas en la Base de Datos (BD)

    // Guardar
    public Detalle guardarDetalle(Detalle datosDetalle) throws Exception{
        try{
            // Validar los datos de entrada
            return this.repositorio.save(datosDetalle);

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar todos los registros
    public List<Detalle> buscarDetalles() throws Exception{
        try{

            return this.repositorio.findAll();

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar por ID
    public Detalle buscarDetallePorId(Integer idDetalle) throws Exception{
        try{

            Optional<Detalle> detalleBuscado=this.repositorio.findById(idDetalle);
            if (detalleBuscado.isPresent()){
                return detalleBuscado.get();
            }else {
                throw new Exception("La detalle consultada no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar por ID
    public Detalle modificarDetalle(Integer id, Detalle datosDetalle) throws Exception{
        try{

            Optional<Detalle> detalleBuscado=this.repositorio.findById(id);
            if (detalleBuscado.isPresent()){
                detalleBuscado.get().setCantidad(datosDetalle.getCantidad());
                detalleBuscado.get().setSubTotal(datosDetalle.getSubTotal());
                return this.repositorio.save(detalleBuscado.get());
            }else{
                throw new Exception("Detalle no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarDetalle(Integer id) throws Exception{
        try{

            Optional<Detalle> detalleBuscado=this.repositorio.findById(id);
            if (detalleBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Detalle no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
