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
public class Profile {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	private boolean deleted = false;
	
	@OneToMany(mappedBy = "user")
	private List<Pantry> pantry_items;
	
	@OneToMany(mappedBy = "profile")
	private List<Recipe> recipes;
	
	@OneToMany(mappedBy = "profile")
	private List<Workout> workouts;
}
