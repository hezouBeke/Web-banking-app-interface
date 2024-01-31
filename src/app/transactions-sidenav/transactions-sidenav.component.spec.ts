import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionsSidenavComponent } from './transactions-sidenav.component';

describe('TransactionsSidenavComponent', () => {
  let component: TransactionsSidenavComponent;
  let fixture: ComponentFixture<TransactionsSidenavComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TransactionsSidenavComponent]
    });
    fixture = TestBed.createComponent(TransactionsSidenavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
