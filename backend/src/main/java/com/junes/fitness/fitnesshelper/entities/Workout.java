package com.junes.fitness.fitnesshelper.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Workout {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String muscle;
	
	@ManyToMany
	@JoinTable(
			name = "Workout_Exercises",
			joinColumns = @JoinColumn(name = "workout_id"),
			inverseJoinColumns = @JoinColumn(name = "exercises_id"))
	private List<Exercise> exercises;
}
