package com.junes.fitness.fitnesshelper.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Recipe {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String course;
	
	@Column 
	private String[] instructions;
	
	private boolean deleted = false;
	
	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
	private List<Ingredient> ingredients;
	
	@ManyToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;
}
