import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodTipsPageComponent } from './food-tips-page.component';

describe('FoodTipsPageComponent', () => {
  let component: FoodTipsPageComponent;
  let fixture: ComponentFixture<FoodTipsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FoodTipsPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FoodTipsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
