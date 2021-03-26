import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnagraficaClienteRegistratoComponent } from './anagrafica-cliente-registrato.component';

describe('AnagraficaClienteRegistratoComponent', () => {
  let component: AnagraficaClienteRegistratoComponent;
  let fixture: ComponentFixture<AnagraficaClienteRegistratoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnagraficaClienteRegistratoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnagraficaClienteRegistratoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
