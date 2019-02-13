import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ejercicio1',
  templateUrl: './ejercicio1.component.html',
  styleUrls: ['./ejercicio1.component.css']
})
export class Ejercicio1Component implements OnInit {
  textonombre = 'Introduce un nombre';
  textoapellidos = 'Introduce los apellidos';
  nombre = '';
  apellidos = '';
  constructor() { }
  ngOnInit() {
  }
}
