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
public class Ingredient {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private double amount;
	
	@Column
	private String measurement;
	
	private boolean deleted = false;
	
	@ManyToOne
	@JoinColumn(name = "Recipe_ID")
	private Recipe recipe;
	
	@ManyToOne
	@JoinColumn(name = "Food_ID")
	private All_Food food_item;
}
