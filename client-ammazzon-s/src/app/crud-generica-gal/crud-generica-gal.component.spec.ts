import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudGenericaGalComponent } from './crud-generica-gal.component';

describe('CrudGenericaGalComponent', () => {
  let component: CrudGenericaGalComponent;
  let fixture: ComponentFixture<CrudGenericaGalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudGenericaGalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrudGenericaGalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
