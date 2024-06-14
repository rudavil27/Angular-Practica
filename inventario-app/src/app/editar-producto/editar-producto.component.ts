import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
    selector: 'app-editar-producto',
    templateUrl: './editar-producto.component.html',
    standalone: true,
    imports: [FormsModule]
})
export class EditarProductoComponent {
producto: Producto= new Producto();
id: number
constructor(private ProductoServicio: ProductoService, private ruta:ActivatedRoute,
   private enrutador:Router){}
ngOnInit(){
  this.id= this.ruta.snapshot.params['id'];
this.ProductoServicio.obtenerPorductoPorId(this.id).subscribe(
  {
    next:(datos)=>this.producto=datos
    ,
    error:(errores:any)=>console.log(errores)
  }
)
}
onSubmit(){
  this.guardarProducto();
}
guardarProducto(){
    this.ProductoServicio.editarProducto(this.id, this.producto).subscribe(
      {
      next: (datos)=>this.irProductoLista(),
      error:(errores)=> console.log(errores)
      }
  );
}
irProductoLista(){
  this.enrutador.navigate(['/productos']);
}
}


