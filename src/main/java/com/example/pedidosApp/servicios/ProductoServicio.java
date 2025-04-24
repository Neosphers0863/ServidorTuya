package com.example.pedidosApp.servicios;

import com.example.pedidosApp.modelos.Producto;
import com.example.pedidosApp.repositorios.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    IProducto repositorio;
    // Listar los metodos que activaran las consultas en la Base de Datos (BD)

    // Guardar
    public Producto guardarProducto(Producto datosProducto) throws Exception{
        try{
            // Validar los datos de entrada
            return this.repositorio.save(datosProducto);

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar todos los registros
    public List<Producto> buscarProductos() throws Exception{
        try{

            return this.repositorio.findAll();

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }

    // Buscar por ID
    public Producto buscarProductoPorId(Integer idProducto) throws Exception{
        try{

            Optional<Producto> productoBuscado=this.repositorio.findById(idProducto);
            if (productoBuscado.isPresent()){
                return productoBuscado.get();
            }else {
                throw new Exception("El producto consultado no esta en la BD");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Modificar por ID
    public Producto modificarProducto(Integer id, Producto datosProducto) throws Exception{
        try{

            Optional<Producto> productoBuscado=this.repositorio.findById(id);
            if (productoBuscado.isPresent()){
                productoBuscado.get().setNombre(datosProducto.getNombre());
                productoBuscado.get().setPrecio(datosProducto.getPrecio());
                return this.repositorio.save(productoBuscado.get());
            }else{
                throw new Exception("Producto no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarProducto(Integer id) throws Exception{
        try{

            Optional<Producto> productoBuscado=this.repositorio.findById(id);
            if (productoBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Producto no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
