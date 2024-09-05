package com.junes.fitness.fitnesshelper.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class All_Exercise {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String muscle;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy = "exercise")
	private List<Exercise> exercises;
}
