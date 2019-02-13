import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';
import {TaskServiceService} from '../services/task-service.service';
@Component({
  selector: 'app-gestor-tareas',
  templateUrl: './gestor-tareas.component.html',
  styleUrls: ['./gestor-tareas.component.css'],
  providers: [TaskServiceService]
})
export class GestorTareasComponent implements OnInit {
  tareaEntrada: string;
  constructor(private taskService: TaskServiceService) {
  }

  ngOnInit() {
  }

  crearTarea() {
    if (this.tareaEntrada !== '') {
      const tarea: Task = new Task(false, this.tareaEntrada);
      this.taskService.add(tarea);
    }
  }

  eliminarTarea(indice: number) {
    console.log('El indice a borrar es: ' + indice);
    this.taskService.deleteTarea(indice);
  }
  listarTareas() {
    return this.taskService.findAll();
   }
}
