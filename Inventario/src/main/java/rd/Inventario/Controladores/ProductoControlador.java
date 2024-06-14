/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rd.Inventario.Controladores;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rd.Inventario.Entidades.Producto;
import rd.Inventario.Excepcion.RecursoNoEncontradoExcepcion;
import rd.Inventario.Servicios.ProductoServicio;

/**
 *
 * @author ruben
 */

    

@RestController
//http://locahost:8080/inventario-app
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {

    private static final Logger logger =
           LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    //http://locahost:8080/inventario-app/productos
    @CrossOrigin(value = "http://localhost:4200")
    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos obtenidos:");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }
@PostMapping("/productos")
public Producto agregarProducto(@RequestBody Producto producto){
    logger.info("Producto a Agregar :" + producto);
    return this.productoServicio.gurdarProducto(producto);
}
@GetMapping("/productos/{id}")
public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id){
    
    Producto producto=
            this.productoServicio.buscarProductoPorId(id);
    
    if(producto!=null)
      return ResponseEntity.ok(producto);
    else
        throw new RecursoNoEncontradoExcepcion("No se encontro el id "+ id);
}

@PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable int id,
            @RequestBody Producto productoRecibido){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
          if(producto== null)
        throw new RecursoNoEncontradoExcepcion("Producto no encontrado"+id);
          
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setPrecio(productoRecibido.getPrecio());
        producto.setExistencia(productoRecibido.getExistencia());
        this.productoServicio.gurdarProducto(producto);
        return ResponseEntity.ok(producto);
    }
@DeleteMapping("/productos/{id}")
public ResponseEntity<Map<String,Boolean>> eliminarProducto(@PathVariable int id){
    Producto producto=productoServicio.buscarProductoPorId(id);
    if(producto== null)
        throw new RecursoNoEncontradoExcepcion("Producto no encontrado"+id);
    this.productoServicio.eliminarProductoPorId(producto.getIdProducto());
    Map<String, Boolean> respuesta=new HashMap<>();
    respuesta.put("Eliminado", Boolean.TRUE);
    return ResponseEntity.ok(respuesta);
    
}
}