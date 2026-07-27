import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyChild1 } from './my-child-1';

describe('MyChild1', () => {
  let component: MyChild1;
  let fixture: ComponentFixture<MyChild1>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MyChild1],
    }).compileComponents();

    fixture = TestBed.createComponent(MyChild1);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
