import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeSkillMappingModalComponent } from './employee-skill-mapping-modal.component';

describe('EmployeeSkillMappingModalComponent', () => {
  let component: EmployeeSkillMappingModalComponent;
  let fixture: ComponentFixture<EmployeeSkillMappingModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeSkillMappingModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeSkillMappingModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
