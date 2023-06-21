import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewClubsComponent } from './view-clubs.component';

describe('ViewClubsComponent', () => {
  let component: ViewClubsComponent;
  let fixture: ComponentFixture<ViewClubsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewClubsComponent]
    });
    fixture = TestBed.createComponent(ViewClubsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
