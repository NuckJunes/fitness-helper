import { Component } from '@angular/core';
import All_Exercise_DTO from '../models/All_Exercise_DTO';
import { CRUD } from '../../services/api';
import { NavMenuComponent } from "../nav-menu/nav-menu.component";
import { CommonModule } from '@angular/common';
import {MatInputModule} from '@angular/material/input';

@Component({
  selector: 'app-exercise-page',
  standalone: true,
  imports: [NavMenuComponent, CommonModule, MatInputModule],
  templateUrl: './exercise-page.component.html',
  styleUrl: './exercise-page.component.css'
})

export class ExercisePageComponent {

  exercises: All_Exercise_DTO[] = [];
  exercises_searched: All_Exercise_DTO[] = [];
  name: String = "";

  ngOnInit() {
    //this.getExercises(); THIS WORKS

    let exercise = {
      name: "Bicep Curls",
      muscle: "Bicep",
      description: "Curl arms up!"
    };
    this.exercises.push(exercise);
    this.exercises_searched = this.exercises;
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

  doSomething(event: string) {
    this.exercises_searched = [];
    this.exercises.forEach(element => {
      if(element.name.includes(event)) {
        this.exercises_searched.push(element);
      }
    });
  }
}
