package com.junes.fitness.fitnesshelper.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Exercise {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private double weight;
	
	@Column
	private int time_seconds;
	
	@Column
	private int reps;
	
	@ManyToOne
	@JoinColumn(name = "workout_ID")
	private Workout workout;
	
	@ManyToOne
	@JoinColumn(name = "Exercise_ID")
	private All_Exercise exercise;
	
	private boolean deleted = false;

	
}
