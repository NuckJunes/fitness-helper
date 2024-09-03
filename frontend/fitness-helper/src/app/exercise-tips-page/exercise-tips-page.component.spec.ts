import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseTipsPageComponent } from './exercise-tips-page.component';

describe('ExerciseTipsPageComponent', () => {
  let component: ExerciseTipsPageComponent;
  let fixture: ComponentFixture<ExerciseTipsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ExerciseTipsPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExerciseTipsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
