import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigateBarComponent } from './navigate-bar.component';

describe('NavigateBarComponent', () => {
  let component: NavigateBarComponent;
  let fixture: ComponentFixture<NavigateBarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavigateBarComponent]
    });
    fixture = TestBed.createComponent(NavigateBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
