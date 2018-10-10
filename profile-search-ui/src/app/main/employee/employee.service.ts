import { Injectable } from "@angular/core";
import { HttpClient} from "@angular/common/http";


import { GlobalVariable } from '../../core/path-config';
import { Employee } from "./employee.model";
import { EmployeeSkill } from "../search/employee-skill.model";

const GET_EMPLOYEE_LIST = 'employee';
const GET_EMPLOYEE_BY_ID = 'employeeById/'
const CREATE_EMPLOYEE = 'employee/';
const GET_SKILL_BASED_PROFILES = 'empSkillDetails/findEmployeeSkillDetails';
const  MAP_SKILLS = 'empSkillDetails/'


@Injectable()
export class EmployeeService {
 constructor(private http: HttpClient){
 }

 getEmployees(){
    return this.http.get<Employee[]>(GlobalVariable.BASE_API_URL + GET_EMPLOYEE_LIST);
}
 
createEmployee(employee){
    return this.http.post<Employee>(GlobalVariable.BASE_API_URL + CREATE_EMPLOYEE,employee);
}
getEmployeeById(id){
    return this.http.get<Employee>(GlobalVariable.BASE_API_URL + GET_EMPLOYEE_BY_ID + id);
}

 getEmployeeSkillDetails(){
     return this.http.get<Employee[]>(GlobalVariable.BASE_API_URL + GET_EMPLOYEE_LIST);
 }

 mapEmployeeAndSkill(employeeId,skills){
    return this.http.post<Employee>(GlobalVariable.BASE_API_URL + MAP_SKILLS + employeeId,skills);
}

 getSkillBasedProfiles(skills){
    let skillDetailDTOList = skills;
    return this.http.post<EmployeeSkill>(GlobalVariable.BASE_API_URL + GET_SKILL_BASED_PROFILES,{skillDetailDTOList}  );
 }
    
}