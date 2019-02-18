import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfesoresRoutingModule } from './profesores-routing.module';
import { ProfesoresComponent } from './profesores.component';
import { PageHeaderModule } from 'src/app/shared';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [ProfesoresComponent],
  imports: [
    CommonModule,
    ProfesoresRoutingModule,
    PageHeaderModule,
    ReactiveFormsModule,
  ]
})
export class ProfesoresModule { }
