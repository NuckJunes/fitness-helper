package com.junes.fitness.fitnesshelper.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class All_Food {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private String type;
	
	private boolean deleted = false;
	
	@OneToMany(mappedBy = "food_item")
	private List<Pantry> pantry_items;
	
	@OneToMany(mappedBy = "All_Food")
	private List<Ingredient> ingredients;
}
