package com.junes.fitness.fitnesshelper.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutResponseDTO {

	private long id;
	
	private String name;
	
	private String muscle;
	
	private int time_minutes;
	
	private String imageURL;
	
	private List<ExerciseDTO> exercises;
}
