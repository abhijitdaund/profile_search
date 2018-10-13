import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { SkillService } from '../../skill/skill.service';
import { BsModalRef } from 'ngx-bootstrap';

@Component({
  selector: 'app-employee-skill-mapping-modal',
  templateUrl: './employee-skill-mapping-modal.component.html',
  styleUrls: ['./employee-skill-mapping-modal.component.css']
})
export class EmployeeSkillMappingModalComponent implements OnInit {

  @Output() submit$  =  new EventEmitter<any>();
  
  selectedEmployee;
  


   
  skills = [];
  selectedSkills = [];
  skillDropdownSettings = {};
  showFilters = true;

  clear(){
    this.selectedSkills = [];
    this.showFilters = true;
  }

constructor(public bsModalRef: BsModalRef ,private employeeService: EmployeeService, private skillService: SkillService) { }

  ngOnInit(){
    this.skills = [{
        id:1,
        skillName:'Angular'
    },
    {
      id:2,
      skillName:'Java'
  }
,{
  id:3,
  skillName:'React'
}]
    this.getSkills();
    this.selectedSkills = [];
    this.skillDropdownSettings = { 
                              singleSelection: false, 
                              text:"Select Skills",
                              selectAllText:'Select All',
                              unSelectAllText:'UnSelect All',
                              enableSearchFilter: true,
                              classes:"w-80",
                              primaryKey:"skillName"
                            }; 
         
}

onLevelSelect(skill:any){
  console.log(skill);
}
OnLevelDeSelect(skill:any){
    console.log(skill);
    
}


onItemSelect(item:any){
  this.showFilters = true;
  this.showFilters = true;
}
OnItemDeSelect(item:any){
    console.log(item);
    this.showFilters = true;
}
onSelectAll(items: any){
    console.log(items);
  this.showFilters = true;

}
onDeSelectAll(items: any){
    console.log(items);
  this.showFilters = true;

}


 getSkills(){
  this.skillService.getSkills().subscribe((response)=>{
             this.skills = response;
  });
   }


   onSubmit(){
    let fromatedSkills = [];
    this.selectedSkills.forEach(skill => {
      if(skill.beginner){
        let o = {
          skillName:skill.skillName,
          levelName:'Beginner'
        }
        fromatedSkills.push(o);
      }

      if(skill.Intermediate){
        let o = {
          skillName:skill.skillName,
          levelName:'Intermediate'
        }
        fromatedSkills.push(o);
      }


      if(skill.expert){
        let o = {
          skillName:skill.skillName,
          levelName:'Expert'
        }
        fromatedSkills.push(o);
      }

      if(!skill.expert && !skill.Intermediate && !skill.beginner){
        let o = {
          skillName:skill.skillName
        }
        fromatedSkills.push(o);
      }
      
    });
     let data = {
       employeeId:this.selectedEmployee.empId,
       selectedSkills:fromatedSkills
     }
     
    this.submit$.emit(data);
  }



  }