import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeRegistrationFormComponent } from './employee-registration-form-component';

describe('EmployeeRegistrationFormComponent', () => {
  let component: EmployeeRegistrationFormComponent;
  let fixture: ComponentFixture<EmployeeRegistrationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EmployeeRegistrationFormComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(EmployeeRegistrationFormComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
