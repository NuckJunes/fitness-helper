import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ExercisePageComponent } from './exercise-page/exercise-page.component';
import { WorkoutPageComponent } from './workout-page/workout-page.component';
import { ExerciseTipsPageComponent } from './exercise-tips-page/exercise-tips-page.component';

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'exercise', component: ExercisePageComponent},
    {path: 'workout', component: WorkoutPageComponent},
    {path: 'exercise-tips', component: ExerciseTipsPageComponent}
];
