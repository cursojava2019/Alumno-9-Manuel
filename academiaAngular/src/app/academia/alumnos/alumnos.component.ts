import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { AlumnoService } from '../../shared/services/alumno.service';
import { Alumno } from '../../shared/entities/alumno';

@Component({
  selector: 'app-alumnos',
  templateUrl: './alumnos.component.html',
  styleUrls: ['./alumnos.component.scss'],
  animations: [routerTransition()]
})
export class AlumnosComponent implements OnInit {
  alumnos: Array<Alumno>;
  constructor(alumnosService: AlumnoService) {
    this.alumnos = alumnosService.findAll();
  }

  ngOnInit() {
  }

  modificar(id: number) {
    console.log(id);
  }
  eliminar(id: number) {

  }
}
