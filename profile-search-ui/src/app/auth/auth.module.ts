import { NgModule } from '@angular/core';
import { Routes ,RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { EmployeeComponent } from '../main/employee/employee.component';
import { FormsModule } from '@angular/forms';

export const routes: Routes = [
  {
      path: '',
      children:[
            {
              path: 'login',
              component: LoginComponent,
            },
            {
              path: '',
              redirectTo:'login',
              pathMatch:'full'
            }
      ],
    }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule
  ],
  declarations: [LoginComponent]
})
export class AuthModule { }
