import { Component, OnInit } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap';
import { SkillRegistrationModalComponent } from './skill-registration-modal/skill-registration-modal.component';
import { SkillService } from './skill.service';
import { Skill } from './skill.model';

@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {
  bsModalRef: BsModalRef;
  skills:Skill[];

  constructor(private modalService: BsModalService, private skillService: SkillService) { }

  ngOnInit() {
    this.getSkills();
  }

  triggerAddSkill(){
    this.bsModalRef = this.modalService.show(SkillRegistrationModalComponent, {
      class:'modal-md'
     });

     this.bsModalRef.content.submit$.subscribe((skill)=>{
       this.skillService.createSkill(skill).subscribe((response)=>{
        this.bsModalRef.hide();
        this.getSkills();
       });
      
     });
  }

  getSkills(){
    this.skillService.getSkills().subscribe((response)=>{
               this.skills = response;
    });
  }

}
