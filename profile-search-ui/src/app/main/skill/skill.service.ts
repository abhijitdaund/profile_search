import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Skill } from "./skill.model";

import { GlobalVariable } from '../../core/path-config';

const GET_SKILL_LIST = 'skill';
const GET_SKILL_BY_ID = 'skillById/'
const CREATE_SKILL = 'skill';


@Injectable()
export class  SkillService {

 constructor(private http: HttpClient){

 }
 

 createSkill(skill){
    return this.http.post<Skill>(GlobalVariable.BASE_API_URL + CREATE_SKILL,skill);
}
getSkillById(id){
    return this.http.get<Skill>(GlobalVariable.BASE_API_URL + GET_SKILL_BY_ID + id);
}

 getSkills(){
     return this.http.get<Skill[]>(GlobalVariable.BASE_API_URL + GET_SKILL_LIST);
 }
    
}