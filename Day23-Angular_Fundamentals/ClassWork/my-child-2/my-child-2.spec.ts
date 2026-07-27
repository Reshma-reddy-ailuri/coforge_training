import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyChild2 } from './my-child-2';

describe('MyChild2', () => {
  let component: MyChild2;
  let fixture: ComponentFixture<MyChild2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MyChild2],
    }).compileComponents();

    fixture = TestBed.createComponent(MyChild2);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
