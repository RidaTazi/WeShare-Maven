import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicationDonsComponent } from './publication-dons.component';

describe('PublicationDonsComponent', () => {
  let component: PublicationDonsComponent;
  let fixture: ComponentFixture<PublicationDonsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PublicationDonsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicationDonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
