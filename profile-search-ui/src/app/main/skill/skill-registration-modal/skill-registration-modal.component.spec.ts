import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SkillRegistrationModalComponent } from './skill-registration-modal.component';

describe('SkillRegistrationModalComponent', () => {
  let component: SkillRegistrationModalComponent;
  let fixture: ComponentFixture<SkillRegistrationModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SkillRegistrationModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SkillRegistrationModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
