import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';
@Component({
  selector: 'app-ejercicio2',
  templateUrl: './ejercicio2.component.html',
  styleUrls: ['./ejercicio2.component.css']
})
export class Ejercicio2Component implements OnInit {
  empleado: Task;
  constructor() {
    this.empleado = new Task('pepe', 19, [1700, 1500, 1300]);
  }

  ngOnInit() {
  }
}
