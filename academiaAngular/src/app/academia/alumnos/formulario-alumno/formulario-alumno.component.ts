import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Alumno } from 'src/app/shared/entities/alumno';

@Component({
  selector: 'app-formulario-alumno',
  templateUrl: './formulario-alumno.component.html',
  styleUrls: ['./formulario-alumno.component.scss']
})
export class FormularioAlumnoComponent implements OnInit {
  miFormulario: FormGroup;

  @Input()
  modificar = false;

  @Input()
  alumnoModificar: Alumno;

  @Output()
  modificado = new EventEmitter<Alumno>();

  constructor(private fb: FormBuilder) {
    this.miFormulario = this.fb.group({
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
      'repetidor': this.fb.control('', [
      ]),
      'observaciones': this.fb.control('', [
        Validators.maxLength(1000)
      ]),
      'fechaAlta': this.fb.control('', [
      ]),
    });
  }

  ngOnInit() {
  }

  guardarCambios() {
    console.log('guardar cambios');
    const alumnoForm: Alumno = this.miFormulario.value;
    alumnoForm.fechaAlta = new Date();
    this.modificado.next(alumnoForm);
    console.log('fin');
  }
}
