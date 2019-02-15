import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlumnosRoutingModule } from './alumnos-routing.module';
import { AlumnosComponent } from './alumnos.component';
import { PageHeaderModule } from '../../shared';

@NgModule({
  declarations: [AlumnosComponent],
  imports: [
    CommonModule,
    AlumnosRoutingModule,
    PageHeaderModule,
  ]
})
export class AlumnosModule { }
