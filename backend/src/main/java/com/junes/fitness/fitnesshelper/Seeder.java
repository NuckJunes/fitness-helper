package com.junes.fitness.fitnesshelper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.junes.fitness.fitnesshelper.entities.Profile;
import com.junes.fitness.fitnesshelper.entities.Workout;
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
	private final ExerciseRepository exerciseRepository;
	private final IngredientRepository ingredientRepository;
	private final PantryRepository pantryRepository;
	private final ProfileRepository profileRepository;
	private final RecipeRepository recipeRepository;
	private final WorkoutRepository workoutRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Profile profile1 = new Profile();
		profile1.setUsername("NuckJunes");
		profile1.setPassword("password");
		profile1.setEmail("Email@Email.com");
		profileRepository.saveAndFlush(profile1);
		
		Workout workout1 = new Workout();
		workout1.setProfile(profile1);
		workout1.setMuscle("Arms");
		workout1.setName("Arm DAY!!!!");
		workout1.setTime_minutes(30);
		workoutRepository.saveAndFlush(workout1);
		
		List<Workout> workouts = new ArrayList<>();
		workouts.add(workout1);
		profile1.setWorkouts(workouts);
		profileRepository.saveAndFlush(profile1);
		
	}
}
