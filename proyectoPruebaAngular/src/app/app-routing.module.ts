import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { MiComponenteComponent } from './mi-componente/mi-componente.component';
import { GestorTareasComponent } from './gestor-tareas/gestor-tareas.component';

const routes: Routes = [
  { path: '', component: MiComponenteComponent },
  { path: 'path2', component: GestorTareasComponent },
  { path: 'path3', component: MiComponenteComponent },
  { path: '**', component: MiComponenteComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeatureRoutingModule {}

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
