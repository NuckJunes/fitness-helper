package com.junes.fitness.fitnesshelper.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutRequestDTO {

	private String name;
	
	private String muscle_group;
	
	private int time_minutes;
	
	private String imageURL;
	
	private List<ExerciseDTO> exercises;
}
