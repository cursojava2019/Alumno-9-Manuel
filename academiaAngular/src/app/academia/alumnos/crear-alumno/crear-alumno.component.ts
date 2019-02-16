import { Component, OnInit } from '@angular/core';
import { routerTransition } from 'src/app/router.animations';

@Component({
  selector: 'app-crear-alumno',
  templateUrl: './crear-alumno.component.html',
  styleUrls: ['./crear-alumno.component.scss'],
  animations: [routerTransition()]
})
export class CrearAlumnoComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
