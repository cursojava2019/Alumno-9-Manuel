import { Component, OnInit } from '@angular/core';
import { routerTransition } from 'src/app/router.animations';
import { Profesor } from 'src/app/shared/entities/profesor';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfesorService } from 'src/app/shared/services/profesor.service';

@Component({
  selector: 'app-modificar-profesor',
  templateUrl: './modificar-profesor.component.html',
  styleUrls: ['./modificar-profesor.component.scss'],
  animations: [routerTransition()]
})
export class ModificarProfesorComponent implements OnInit {
  profesorActual: Profesor;
  constructor(private rutaActiva: ActivatedRoute, private profesorService: ProfesorService, private router: Router) {

  }

  ngOnInit() {
    let id = null;
    id = this.rutaActiva.snapshot.params.idprofesor;
    this.profesorService.findById(id).subscribe(data => {
      this.profesorActual = data;
      console.log(this.profesorActual);
    });
  }

  modificar(a: Profesor) {
    this.profesorService.modificar(a).subscribe(data => {
      this.router.navigate(['profesores']);
    });
  }

}
