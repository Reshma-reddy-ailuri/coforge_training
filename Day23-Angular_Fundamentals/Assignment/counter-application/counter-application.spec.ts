import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CounterApplication } from './counter-application';

describe('CounterApplication', () => {
  let component: CounterApplication;
  let fixture: ComponentFixture<CounterApplication>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CounterApplication],
    }).compileComponents();

    fixture = TestBed.createComponent(CounterApplication);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
