import { Injectable } from '@angular/core';
import { MapType } from '@angular/compiler';
import { Alumno } from '../entities/alumno';

@Injectable({
  providedIn: 'root'
})
export class AlumnoService {
  listado: Array<Alumno>;
  constructor() {
    this.listado = new Array<Alumno>();
    this.listado.push(
      new Alumno(1, 'David', 'Tello', 'Sanchez', 'a@a.es', new Date(), null, '95360236Y', 'Nada', false, '953602528'),
      new Alumno(2, 'Manuel', 'Garin', 'Moriana', 'a@a.es', new Date(), null, '26252827Y', 'Nada', false, '953602528')
    );
  }
  findAll() {
    return this.listado;
  }
  findById(index: number) {
    return this.listado[index];
  }
  create(a: Alumno) {
    this.listado.push(a);
  }
  delete(index: number) {
    return this.listado.splice(index, 1);
  }
}
