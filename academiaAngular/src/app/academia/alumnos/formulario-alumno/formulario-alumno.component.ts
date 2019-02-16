import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario-alumno',
  templateUrl: './formulario-alumno.component.html',
  styleUrls: ['./formulario-alumno.component.scss']
})
export class FormularioAlumnoComponent implements OnInit {
  miFormulario: FormGroup;
  constructor(private fb: FormBuilder) {
    this.miFormulario = this.fb.group({
      'nombre': this.fb.control('', [
        Validators.required,
        Validators.minLength(3)
      ]),
    });
  }

  ngOnInit() {
  }

  guardarCambios() {

  }
}
