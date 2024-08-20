package com.junes.fitness.fitnesshelper.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Exercise {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private double weight;
	
	//time
	
	@Column
	private int reps;
	
	@ManyToMany(mappedBy = "exercises")
	private List<Workout> workouts;
	
}
