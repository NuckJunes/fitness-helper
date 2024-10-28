import { Component } from '@angular/core';
import All_Exercise_DTO from '../models/All_Exercise_DTO';
import { CRUD } from '../../services/api';
import { NavMenuComponent } from "../nav-menu/nav-menu.component";
import { CommonModule } from '@angular/common';
import {MatInputModule} from '@angular/material/input';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-exercise-page',
  standalone: true,
  imports: [NavMenuComponent, CommonModule, MatInputModule, MatButtonModule, MatMenuModule],
  templateUrl: './exercise-page.component.html',
  styleUrl: './exercise-page.component.css'
})

export class ExercisePageComponent {

  exercises: All_Exercise_DTO[] = [];
  exercises_searched: All_Exercise_DTO[] = [];
  search_name: string = "";
  muscle_name: string = "";

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

  searchPrompt(event: string) {
    this.search_name = event;
    this.sortValues(this.search_name, this.muscle_name);
  }

  changeSort(muscle: string) {
    this.muscle_name = muscle;
    this.sortValues(this.search_name, this.muscle_name);
  }

  sortValues(search: string, muscle: string) {
    this.exercises_searched = [];
    this.exercises.forEach(element => {
      if(element.name.includes(search) && (element.muscle === muscle || muscle === "")) {
        this.exercises_searched.push(element);
      }
    });
  }
}
