package com.junes.fitness.fitnesshelper.dtos;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutResponseDTO {

	private long id;
	
	private String name;
	
	private String muscle_group;
	
	private int time_minutes;
	
	private String imageURL;
	
	private List<ExerciseDTO> exercises;
}
