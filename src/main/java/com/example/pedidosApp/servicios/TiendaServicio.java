package com.example.pedidosApp.servicios;

import com.example.pedidosApp.modelos.Tienda;
import com.example.pedidosApp.modelos.Usuario;
import com.example.pedidosApp.repositorios.ITienda;
import com.example.pedidosApp.repositorios.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaServicio {

    @Autowired
    ITienda repositorio;
    // Listar los metodos que activaran las consultas en la Base de Datos (BD)

    // Guardar
    public Tienda guardarTienda(Tienda datosTienda) throws Exception{
        try{
            // Validar los datos de entrada
            return this.repositorio.save(datosTienda);

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar todos los registros
    public List<Tienda> buscarTiendas() throws Exception{
        try{

            return this.repositorio.findAll();

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar por ID
    public Tienda buscarTiendaPorId(Integer idTienda) throws Exception{
        try{

            Optional<Tienda> tiendaBuscado=this.repositorio.findById(idTienda);
            if (tiendaBuscado.isPresent()){
                return tiendaBuscado.get();
            }else {
                throw new Exception("Latienda consultada no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar por ID
    public Tienda modificarTienda(Integer id, Tienda datosTienda) throws Exception{
        try{

            Optional<Tienda> tiendaBuscado=this.repositorio.findById(id);
            if (tiendaBuscado.isPresent()){
                tiendaBuscado.get().setTelefono(datosTienda.getTelefono());
                tiendaBuscado.get().setDireccion(datosTienda.getDireccion());
                return this.repositorio.save(tiendaBuscado.get());
            }else{
                throw new Exception("Tienda no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarTienda(Integer id) throws Exception{
        try{

            Optional<Tienda> tiendaBuscado=this.repositorio.findById(id);
            if (tiendaBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Tienda no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
