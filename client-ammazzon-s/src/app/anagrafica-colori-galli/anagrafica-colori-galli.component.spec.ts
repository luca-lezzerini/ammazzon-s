import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnagraficaColoriGalliComponent } from './anagrafica-colori-galli.component';

describe('AnagraficaColoriGalliComponent', () => {
  let component: AnagraficaColoriGalliComponent;
  let fixture: ComponentFixture<AnagraficaColoriGalliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnagraficaColoriGalliComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnagraficaColoriGalliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
