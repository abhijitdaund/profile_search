import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import{ HttpClientModule } from '@angular/common/http'


import { PaginationModule, ModalModule, BsDropdownModule } from 'ngx-bootstrap';
import { AngularMultiSelectModule } from 'angular2-multiselect-dropdown/angular2-multiselect-dropdown';
import { SharedModule } from '../shared/shared.module';

import { EmployeeComponent } from './employee/employee.component';
import { EmployeeRegistrationModalComponent } from './employee/employee-registration-modal/employee-registration-modal.component';
import { SkillComponent } from './skill/skill.component';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './main.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { EmployeeService } from './employee/employee.service';
import { SkillRegistrationModalComponent } from './skill/skill-registration-modal/skill-registration-modal.component';
import { SkillService } from './skill/skill.service';
import { SearchComponent } from './search/search.component';
import { EmployeeSkillMappingModalComponent } from './employee/employee-skill-mapping-modal/employee-skill-mapping-modal.component';




export const routes: Routes = [
  {
      path: '',
      component:MainComponent,
      children:[
            {
              path: 'employee',
              component: EmployeeComponent,
            },
            {
              path: 'skill',
              component: SkillComponent,
            },
            {
              path: 'search',
              component: SearchComponent,
            },
            {
              path: '',
              redirectTo:'employee',
              pathMatch:'full'
            }
      ],
    }
];

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    PaginationModule.forRoot(),
    ModalModule.forRoot(),
    RouterModule.forChild(routes),
    BsDropdownModule.forRoot(),
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    AngularMultiSelectModule
  ],
  declarations: [EmployeeComponent,
                 EmployeeRegistrationModalComponent,
                  SkillComponent,
                   MainComponent,
                   SkillRegistrationModalComponent,
                   SearchComponent,
                   EmployeeSkillMappingModalComponent
                ],
  entryComponents: [EmployeeRegistrationModalComponent,
    SkillRegistrationModalComponent,
    EmployeeSkillMappingModalComponent],
  providers:[ EmployeeService, SkillService ]
})
export class MainModule { }
