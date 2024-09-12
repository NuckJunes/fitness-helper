package com.junes.fitness.fitnesshelper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.junes.fitness.fitnesshelper.entities.All_Exercise;
import com.junes.fitness.fitnesshelper.entities.Exercise;
import com.junes.fitness.fitnesshelper.entities.Profile;
import com.junes.fitness.fitnesshelper.entities.Workout;
import com.junes.fitness.fitnesshelper.repositories.All_ExerciseRepository;
import com.junes.fitness.fitnesshelper.repositories.All_FoodRepository;
import com.junes.fitness.fitnesshelper.repositories.ExerciseRepository;
import com.junes.fitness.fitnesshelper.repositories.IngredientRepository;
import com.junes.fitness.fitnesshelper.repositories.PantryRepository;
import com.junes.fitness.fitnesshelper.repositories.ProfileRepository;
import com.junes.fitness.fitnesshelper.repositories.RecipeRepository;
import com.junes.fitness.fitnesshelper.repositories.WorkoutRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

	private final All_FoodRepository all_FoodRepository;
	private final All_ExerciseRepository all_ExerciseRepository;
	private final ExerciseRepository exerciseRepository;
	private final IngredientRepository ingredientRepository;
	private final PantryRepository pantryRepository;
	private final ProfileRepository profileRepository;
	private final RecipeRepository recipeRepository;
	private final WorkoutRepository workoutRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//profile to fill everything into
		Profile profile1 = new Profile();
		profile1.setUsername("NuckJunes");
		profile1.setPassword("password");
		profile1.setEmail("Email@Email.com");
		profileRepository.saveAndFlush(profile1);
		
		//All Exercises to be picked from
		All_Exercise all_exercise_1 = new All_Exercise();
		all_exercise_1.setName("Dumbell Bicep Curls");
		all_exercise_1.setMuscle("arms");
		all_exercise_1.setDescription("Grab dumbell, pull up towards body.");
		all_ExerciseRepository.saveAndFlush(all_exercise_1);
		
		All_Exercise all_exercise_2 = new All_Exercise();
		all_exercise_2.setName("Pullups");
		all_exercise_2.setMuscle("lats");
		all_exercise_2.setDescription("Grab bar, lift body up, dont swing, chin above bar.");
		all_ExerciseRepository.saveAndFlush(all_exercise_2);

		All_Exercise all_exercise_3 = new All_Exercise();
		all_exercise_3.setName("Barbell bench press");
		all_exercise_3.setMuscle("chest");
		all_exercise_3.setDescription("Grab bar, push upwards, slowly bring down to chest, repeat.");
		List<Exercise> exercises3 = new ArrayList<>();
		all_exercise_3.setExercises(exercises3);
		all_ExerciseRepository.saveAndFlush(all_exercise_3);
		
		//Workouts
		Workout workout1 = new Workout();
		workout1.setProfile(profile1);
		workout1.setMuscle("Arms");
		workout1.setName("Arm DAY!!!!");
		workout1.setTime_minutes(30);
		workoutRepository.saveAndFlush(workout1);
		
		//Exercises in workouts
		Exercise exercise1 = new Exercise();
		exercise1.setWeight(50.0);
		exercise1.setTime_seconds(-1);
		exercise1.setReps(5);
		exercise1.setExercise(all_exercise_1);
		exercise1.setWorkout(workout1);
		
		exerciseRepository.saveAndFlush(exercise1);
		
		List<Exercise> exercises = new ArrayList<>();
		exercises.add(exercise1);
		all_exercise_1.setExercises(exercises);
		all_ExerciseRepository.saveAndFlush(all_exercise_1);
		
		Exercise exercise2 = new Exercise();
		exercise2.setWeight(-1.0);
		exercise2.setTime_seconds(30);
		exercise2.setReps(8);
		exercise2.setExercise(all_exercise_2);
		exercise2.setWorkout(workout1);
		
		exerciseRepository.saveAndFlush(exercise2);
		
		List<Exercise> exercises2 = new ArrayList<>();
		exercises2.add(exercise2);
		all_exercise_2.setExercises(exercises2);
		all_ExerciseRepository.saveAndFlush(all_exercise_2);

		
		//add exercises into workout
		List<Exercise> workout1_exercises = new ArrayList<>();
		workout1_exercises.add(exercise1);
		workout1_exercises.add(exercise2);
		workout1.setExercises(workout1_exercises);
		workoutRepository.saveAndFlush(workout1);
		
		List<Workout> workouts = new ArrayList<>();
		workouts.add(workout1);
		profile1.setWorkouts(workouts);
		profileRepository.saveAndFlush(profile1);
		
	}
}
