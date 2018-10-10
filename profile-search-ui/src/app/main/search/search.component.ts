import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee/employee.service';
import { SkillService } from '../skill/skill.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  employees;
  constructor(private employeeService: EmployeeService, private skillService: SkillService) { }


 
  skills = [];
  selectedSkills = [];
  skillDropdownSettings = {};
  showFilters = true;

  clear(){
    this.selectedSkills = [];
    this.showFilters = true;
  }
  ngOnInit(){
    
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


  onItemSelect(item:any){
    this.showFilters = true;
    this.showFilters = true;
    this.applyFilter();

     
  }
  OnItemDeSelect(item:any){
      console.log(item);
      this.showFilters = true;
      this.applyFilter();

     
  }
  onSelectAll(items: any){
      console.log(items);
    this.showFilters = true;
    this.applyFilter();

  }
  onDeSelectAll(items: any){
      console.log(items);
    this.showFilters = true;
    this.applyFilter();

  }


   getSkills(){
    this.skillService.getSkills().subscribe((response)=>{
               this.skills = response;
    });
     }

     applyFilter(){
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
      if(fromatedSkills.length){

        this.employeeService.getSkillBasedProfiles(fromatedSkills).subscribe((response)=>{
          this.employees = response;
             });

      }
      else{
        this.employees = [];
      }
     
  
         }
}

