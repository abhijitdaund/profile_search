import { Component, OnInit } from '@angular/core';

import { BsModalService, BsModalRef } from 'ngx-bootstrap';

import { EmployeeRegistrationModalComponent } from './employee-registration-modal/employee-registration-modal.component';
import { EmployeeService } from './employee.service';
import { Employee } from './employee.model';
import { EmployeeSkillMappingModalComponent } from './employee-skill-mapping-modal/employee-skill-mapping-modal.component';
import { AlertService } from '../../core/alert.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  bsModalRef: BsModalRef;
  employees:Employee[];

  constructor(private modalService: BsModalService,
              private employeeService: EmployeeService,
              private alertService: AlertService) { }

  ngOnInit() {
    this.getEmployees();
   
  }

  triggerAddEmployee(){
    this.bsModalRef = this.modalService.show(EmployeeRegistrationModalComponent, {
      class:'modal-lg'
     });

     this.bsModalRef.content.submit$.subscribe((employee)=>{
       this.employeeService.createEmployee(employee).subscribe((response)=>{
        this.bsModalRef.hide();
        this.getEmployees();
       });
     
     });
  }

  edit(employee){ 
    let initialState = {
      selectedEmployee : employee
    }
    
    this.bsModalRef = this.modalService.show(EmployeeRegistrationModalComponent,Object.assign({},{initialState},{class:'modal-lg'}));

     this.bsModalRef.content.submit$.subscribe((employee)=>{
       this.employeeService.createEmployee(employee).subscribe((response)=>{
        this.bsModalRef.hide();
        this.alertService.success('Employee Successfully Updated');
        this.getEmployees();
       });
     
     });
  }

  search(key){
  if(key.length){
    this.employees = this.employees.filter((employee)=>{
         return employee.firstName.includes(key);
    });
  }
  else{
    this.getEmployees();
  }
  }

  link(employee){ 
    let initialState = {
      selectedEmployee : employee
    }
    
    this.bsModalRef = this.modalService.show(EmployeeSkillMappingModalComponent,Object.assign({},{initialState},{class:'modal-lg'}));

     this.bsModalRef.content.submit$.subscribe((data)=>{

       let skills = {
        skillDetailDTOList: data.selectedSkills
      }

       this.employeeService.mapEmployeeAndSkill(data.employeeId,skills).subscribe((response)=>{
        this.bsModalRef.hide();
        this.alertService.success('Skill Successfully Attached');
        this.getEmployees();
       });
     
     });
  }

  getEmployees(){
    this.employeeService.getEmployees().subscribe((response)=>{
               this.employees = response;
              
              
    });
  }

}
