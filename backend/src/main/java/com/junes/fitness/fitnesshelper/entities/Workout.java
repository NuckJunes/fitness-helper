package com.junes.fitness.fitnesshelper.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	
	@Column
	private int time_minutes;
	
	@ManyToMany
	@JoinTable(
			name = "Workout_Exercises",
			joinColumns = @JoinColumn(name = "workout_id"),
			inverseJoinColumns = @JoinColumn(name = "exercises_id"))
	private List<Exercise> exercises;
	
	@ManyToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;
	
	private boolean deleted = false;

}
