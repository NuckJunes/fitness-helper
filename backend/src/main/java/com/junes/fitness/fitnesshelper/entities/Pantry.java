package com.junes.fitness.fitnesshelper.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Pantry {

	@Column
	private String name;
	
	@Column
	private float amount;
	
	@Column
	private String measurement;
}
