import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Employee } from '../employee.model';
import { BsModalRef } from 'ngx-bootstrap';

@Component({
  selector: 'app-employee-registration-modal',
  templateUrl: './employee-registration-modal.component.html',
  styleUrls: ['./employee-registration-modal.component.css']
})
export class EmployeeRegistrationModalComponent implements OnInit {
  @Output() submit$  =  new EventEmitter<Employee>();
  employeeRegistrationForm;
  selectedEmployee;
  
  constructor(private fb: FormBuilder, public bsModalRef: BsModalRef) { }


  ngOnInit() {
  
   if(this.selectedEmployee){

    this.employeeRegistrationForm  = this.fb.group({
      empId:[this.selectedEmployee.empId, Validators.required],
      firstName: [this.selectedEmployee.firstName, Validators.required],
      middleName: [this.selectedEmployee.middleName],
      lastName: [this.selectedEmployee.lastName],
      gender:[this.selectedEmployee.gender],
      mobile:[this.selectedEmployee.mobile],
      workPhone:[this.selectedEmployee.workPhone],
      workEmail:[this.selectedEmployee.workEmail],
      skypeId:[this.selectedEmployee.skypeId],
      isActive:[this.selectedEmployee.isActive],
      creatorUserId:[this.selectedEmployee.creatorUserId],   //should be populated from session
      lastModifierUserId:[this.selectedEmployee.lastModifierUserId] //should be populated from session
    })

   }
   else{
    this.employeeRegistrationForm  = this.fb.group({
      empId:['', Validators.required],
      firstName: ['', Validators.required],
      middleName: [''],
      lastName: [''],
      gender:[1],
      mobile:[''],
      workPhone:[''],
      workEmail:[''],
      skypeId:[''],
      isActive:[true],
      creatorUserId:['1111'],   //should be populated from session
      lastModifierUserId:['1111'] //should be populated from session
    })

   }
;
  }
  onSubmit(){
    this.submit$.emit(this.employeeRegistrationForm.value);
  }

}
