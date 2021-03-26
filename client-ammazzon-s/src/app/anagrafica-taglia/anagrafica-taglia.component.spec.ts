import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnagraficaTagliaComponent } from './anagrafica-taglia.component';

describe('AnagraficaTagliaComponent', () => {
  let component: AnagraficaTagliaComponent;
  let fixture: ComponentFixture<AnagraficaTagliaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnagraficaTagliaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnagraficaTagliaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
