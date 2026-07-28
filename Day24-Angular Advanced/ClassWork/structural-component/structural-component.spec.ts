import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StructuralComponent } from './structural-component';

describe('StructuralComponent', () => {
  let component: StructuralComponent;
  let fixture: ComponentFixture<StructuralComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StructuralComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(StructuralComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
