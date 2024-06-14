/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rd.Inventario.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import rd.Inventario.Entidades.Producto;

/**
 *
 * @author ruben
 */
public interface ProductoRepositorio  extends JpaRepository<Producto,Integer>{
    
}
