import { Component } from '@angular/core';
import { NavMenuComponent } from '../nav-menu/nav-menu.component';

@Component({
  selector: 'app-workout-page',
  standalone: true,
  imports: [NavMenuComponent],
  templateUrl: './workout-page.component.html',
  styleUrl: './workout-page.component.css'
})
export class WorkoutPageComponent {

}
