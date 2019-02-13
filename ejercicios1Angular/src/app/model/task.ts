export class Task {
  nombre: string;
  edad: number;
  salario: number[];
  constructor(nombre: string, edad: number , salario ) {
     this.nombre = nombre;
     this.edad = edad;
     this.salario = salario;
  }
}
