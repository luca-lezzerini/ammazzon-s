import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssociaTaglieProdottiColoriComponent } from './associa-taglie-prodotti-colori.component';

describe('AssociaTaglieProdottiColoriComponent', () => {
  let component: AssociaTaglieProdottiColoriComponent;
  let fixture: ComponentFixture<AssociaTaglieProdottiColoriComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssociaTaglieProdottiColoriComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssociaTaglieProdottiColoriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
