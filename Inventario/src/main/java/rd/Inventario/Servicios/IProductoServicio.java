/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rd.Inventario.Servicios;

import java.util.List;
import rd.Inventario.Entidades.Producto;

/**
 *
 * @author ruben
 */
public interface IProductoServicio {
    public List<Producto> listarProductos();
    
    public  Producto buscarProductoPorId(Integer idProducto);
    
    public Producto gurdarProducto(Producto producto);
     
    public void eliminarProducto(Integer idProducto);
}
