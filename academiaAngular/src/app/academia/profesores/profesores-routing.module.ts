import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfesoresComponent } from './profesores.component';
import { CrearProfesorComponent } from './crear-profesor/crear-profesor.component';
import { ModificarProfesorComponent } from './modificar-profesor/modificar-profesor.component';

const routes: Routes = [
  {
      path: '',
      component: ProfesoresComponent,
  },
  { path: 'crear', component: CrearProfesorComponent },
  { path: 'modificar/:idProfesor', component: ModificarProfesorComponent }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfesoresRoutingModule { }
