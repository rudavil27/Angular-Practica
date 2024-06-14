/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rd.Inventario.Servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rd.Inventario.Entidades.Producto;
import rd.Inventario.Repositorio.ProductoRepositorio;

/**
 *
 * @author ruben
 */
@Service
public class ProductoServicio implements IProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return this.productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto
                = this.productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto gurdarProducto(Producto producto) {
       return this.productoRepositorio.save(producto);

    }

    public void eliminarProductoPorId(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto);
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

//    @Autowired
//    private ProductoRepositorio productoRepositorio;
//
//    @Override
//    public List<Producto> listarProductos() {
//        return this.productoRepositorio.findAll();
//    }
//
//    @Override
//    public Producto buscarProductoPorId(Integer idProducto) {
//        Producto producto =
//                this.productoRepositorio.findById(idProducto).orElse(null);
//        return producto;
//    }
//
//    @Override
//    public void guardarProducto(Producto producto) {
//        this.productoRepositorio.save(producto);
//    }
//    @Override
//    public void eliminarProductoPorId(Integer idProducto) {
//        this.productoRepositorio.deleteById(idProducto);
//    }
