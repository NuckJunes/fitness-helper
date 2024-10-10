import { Component } from '@angular/core';
import All_Exercise_DTO from '../models/All_Exercise_DTO';
import { CRUD } from '../../services/api';

@Component({
  selector: 'app-exercise-page',
  standalone: true,
  imports: [],
  templateUrl: './exercise-page.component.html',
  styleUrl: './exercise-page.component.css'
})

export class ExercisePageComponent {

  exercises: All_Exercise_DTO | undefined;

  ngOnInit() {
    //API call to grab all exercises from DB
    this.getExercises();
  }

  async getExercises() {
    try {
      const response = await CRUD("GET", "all", ["exercises"], "");
      this.exercises = response;
      console.log(this.exercises);
    } catch(error) {
      console.error("Error getting all exercises:", error);
    }
  }
}
