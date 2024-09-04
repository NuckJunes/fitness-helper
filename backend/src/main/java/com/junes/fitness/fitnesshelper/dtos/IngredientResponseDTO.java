package com.junes.fitness.fitnesshelper.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientResponseDTO {

	private long id;
	
	private double amount;
	
	private String measurement;
	
	private All_Food_DTO All_Food;
}
