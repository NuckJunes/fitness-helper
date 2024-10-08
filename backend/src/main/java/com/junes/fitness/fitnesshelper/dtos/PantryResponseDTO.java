package com.junes.fitness.fitnesshelper.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PantryResponseDTO {

	private long id;
	
	private double amount;
	
	private String measurement;
	
	private All_Food_DTO food_item;
}
