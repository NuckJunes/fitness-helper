import { Component } from '@angular/core';
import { NavMenuComponent } from '../nav-menu/nav-menu.component';
import WorkoutResponseDTO from '../models/WorkoutResponseDTO';

@Component({
  selector: 'app-workout-page',
  standalone: true,
  imports: [NavMenuComponent],
  templateUrl: './workout-page.component.html',
  styleUrl: './workout-page.component.css'
})
export class WorkoutPageComponent {

  workouts: WorkoutResponseDTO[] = [];
  workouts_searched: WorkoutResponseDTO[] = [];
  search_name: string = "";
  muscle_name: string = "";

  ngOnInit() {
    // Use API to get all workouts with profileID
    
  }
}
