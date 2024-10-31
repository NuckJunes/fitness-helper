import { Component } from '@angular/core';
import { NavMenuComponent } from '../nav-menu/nav-menu.component';
import WorkoutResponseDTO from '../models/WorkoutResponseDTO';
import { userInfo } from '../../services/UserInfo';
import { CRUD } from '../../services/api';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-workout-page',
  standalone: true,
  imports: [NavMenuComponent, NgFor],
  templateUrl: './workout-page.component.html',
  styleUrl: './workout-page.component.css'
})
export class WorkoutPageComponent {

  workouts: WorkoutResponseDTO[] = [];
  workouts_searched: WorkoutResponseDTO[] = [];
  search_name: string = "";
  muscle_name: string = "";
  id: number = 0;

  constructor(private userInfo: userInfo) {}

  ngOnInit() {
    this.userInfo.getUserId().subscribe(value => this.id = value);
    // Use API to get all workouts with profileID
    // this.getWorkouts();


  }

  async getWorkouts() {
    try {
      const response = await CRUD("GET", "workout", [this.id.toString()], "");
      this.workouts = response;
    } catch(error) {
      console.error("Error getting all workouts: ", error);
    }
  }
}
