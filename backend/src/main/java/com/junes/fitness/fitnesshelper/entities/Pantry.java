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
public class Pantry {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;
	
	@Column
	private float amount;
	
	@Column
	private String measurement;
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	private All_Food food_item;
	
	@ManyToOne
	@JoinColumn(name = "profile_id")
	private Profile user;
	
	private boolean deleted = false;
}
