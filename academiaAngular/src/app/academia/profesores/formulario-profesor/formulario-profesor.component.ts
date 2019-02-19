import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { routerTransition } from 'src/app/router.animations';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Profesor } from 'src/app/shared/entities/profesor';

@Component({
  selector: 'app-formulario-profesor',
  templateUrl: './formulario-profesor.component.html',
  styleUrls: ['./formulario-profesor.component.scss'],
  animations: [routerTransition()]
})
export class FormularioProfesorComponent implements OnInit {
  miFormulario: FormGroup;

  @Input()
  modificar = false;

  @Input()
  profesorModificar: Profesor;

  @Output()
  modificado = new EventEmitter<Profesor>();

  constructor(private fb: FormBuilder) {

  }

  ngOnInit() {
    this.miFormulario = this.fb.group({
      'id': this.fb.control('', [
      ]),
      'nombre': this.fb.control('', [
        Validators.required,
        Validators.minLength(3)
      ]),
      'apellido1': this.fb.control('', [
        Validators.required,
        Validators.minLength(3)
      ]),
      'apellido2': this.fb.control('', [
        Validators.required,
        Validators.minLength(3)
      ]),
      'nif': this.fb.control('', [
        Validators.required,
        Validators.minLength(9),
        Validators.maxLength(9)
      ]),
      'telefono': this.fb.control('', [
        Validators.required,
      ]),
      'correo': this.fb.control('', [
        Validators.required,
        Validators.email,
      ]),
    });
    if (this.modificar === true) {
      this.miFormulario.patchValue(this.profesorModificar);
    }
  }

  guardarCambios() {
    if (this.modificar === false) {
      const profesorForm: Profesor = this.miFormulario.value;
      this.modificado.next(profesorForm);
    } else {
      const profesorForm: Profesor = this.miFormulario.value;
      this.modificado.next(profesorForm);
    }

  }
}
