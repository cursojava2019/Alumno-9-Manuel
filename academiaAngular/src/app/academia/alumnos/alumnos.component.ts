import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { AlumnoService } from '../../shared/services/alumno.service';
import { Alumno } from '../../shared/entities/alumno';
import { Router } from '@angular/router';

@Component({
  selector: 'app-alumnos',
  templateUrl: './alumnos.component.html',
  styleUrls: ['./alumnos.component.scss'],
  animations: [routerTransition()]
})
export class AlumnosComponent implements OnInit {
  alumnos: Array<Alumno>;
  constructor(private alumnosService: AlumnoService, private router: Router) {
    this.alumnos = alumnosService.findAll();
  }

  ngOnInit() {
  }

  irCrearAlumno() {
    this.router.navigate(['alumnos/crear']);
  }

  modificar(id: number) {
    this.router.navigate(['alumnos/modificar', id]);
  }
  eliminar(id: number) {
    if (confirm('Esta seguro de eliminar el alumno con id: ' + id)) {
      this.alumnosService.delete(id);
    }
  }

}
