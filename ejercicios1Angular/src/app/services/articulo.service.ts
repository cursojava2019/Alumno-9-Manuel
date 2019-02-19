import { Injectable } from '@angular/core';
import { Articulo } from '../model/articulo';

@Injectable({
  providedIn: 'root'
})
export class ArticuloService {

 private listado = Array<Articulo>();

  constructor() {
    this.listado.push(new Articulo(1, 'Pan', 3));
    this.listado.push(new Articulo(2, 'Leche', 6));
    this.listado.push(new Articulo(3, 'Carne', 90));
   }

  add(articulo: Articulo) {
    this.listado.push(articulo);
  }
  addSimple(codigo: number, descripcion: string, precio: number) {
    let articulo = null;
    articulo = new Articulo( codigo, descripcion, precio);
    this.listado.push(articulo);
  }
  findAll() {
    return this.listado;
  }

  updateArticulo(codigo: number) {
  }

  deleteArticulo(codigo: number) {
    console.log(codigo);
    this.listado.splice((codigo - 1), 1);
  }
}
