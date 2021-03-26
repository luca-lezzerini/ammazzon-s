import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnagraficaUtenteRegistratoComponent } from './anagrafica-utente-registrato.component';

describe('AnagraficaUtenteRegistratoComponent', () => {
  let component: AnagraficaUtenteRegistratoComponent;
  let fixture: ComponentFixture<AnagraficaUtenteRegistratoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnagraficaUtenteRegistratoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnagraficaUtenteRegistratoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
