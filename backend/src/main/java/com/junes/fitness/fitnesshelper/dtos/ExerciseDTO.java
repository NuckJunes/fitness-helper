package com.junes.fitness.fitnesshelper.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDTO {

	private double weight;
	
	private int time_seconds;
	
	private int reps;
	
	private String imageURL;
		
	private All_Exercise_DTO exercise;
}
