import { Component } from '@angular/core';
import All_Exercise_DTO from '../models/All_Exercise_DTO';
import { CRUD } from '../../services/api';
import { NavMenuComponent } from "../nav-menu/nav-menu.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-exercise-page',
  standalone: true,
  imports: [NavMenuComponent, CommonModule],
  templateUrl: './exercise-page.component.html',
  styleUrl: './exercise-page.component.css'
})

export class ExercisePageComponent {

  exercises: All_Exercise_DTO[] = [];

  ngOnInit() {
    //this.getExercises(); THIS WORKS

    let exercise = {
      name: "Bicep Curls",
      muscle: "Bicep",
      description: "Curl arms up!"
    };
    this.exercises.push(exercise);
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
