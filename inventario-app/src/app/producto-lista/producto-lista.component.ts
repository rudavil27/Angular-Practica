import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';
import { NgFor } from '@angular/common';

@Component({
    selector: 'app-producto-lista',
    templateUrl: './producto-lista.component.html',
    standalone: true,
    imports: [NgFor]
})
export class ProductoListaComponent {
  productos: Producto[];

  constructor(private productoServicio: ProductoService,
    private enrutador: Router
  ) { }

  ngOnInit() {
    //Cargamos los productos
    this.obtenerProductos();
  }

  private obtenerProductos() {
    // Consumir los datos del observable (suscribirnos)
    this.productoServicio.obtenerProductosLista().subscribe(
      (datos => {
        this.productos = datos;
      })
    );
  }
  editarProducto(id: number) {
    this.enrutador.navigate(['editar-producto', id]);
  }
  eliminarProducto(id: number) {
    this.productoServicio.eliminarProducto(id).subscribe({
      next: (datos) => this.obtenerProductos(),
      error: (errores) => console.log(errores)
    }
    );
  }
}
