import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mi-componente',
  templateUrl: './mi-componente.component.html',
  styleUrls: ['./mi-componente.component.css']
})
export class MiComponenteComponent implements OnInit {
  nombre = 'Paco';
  constructor() { }

  ngOnInit() {
  }

  cambiarNombre(nuevoNombre: string) {
    this.nombre = nuevoNombre;
  }
}
