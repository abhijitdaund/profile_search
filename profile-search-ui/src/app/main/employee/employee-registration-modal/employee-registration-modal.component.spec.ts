import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeRegistrationModalComponent } from './employee-registration-modal.component';

describe('EmployeeRegistrationModalComponent', () => {
  let component: EmployeeRegistrationModalComponent;
  let fixture: ComponentFixture<EmployeeRegistrationModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeRegistrationModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeRegistrationModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
